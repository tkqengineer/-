/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package com.alex.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * This Example will demonstrate how to start and shutdown the Quartz scheduler and how to schedule
 * a job to run in Quartz.
 * 
 * @author Bill Kratzer
 */
public class SimpleCronExample {

    public void run() throws Exception {


        System.out.println("------- Initializing ----------------------");

        // 定义调度器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        System.out.println("------- Initialization Complete -----------");
        // 获取当前时间的下一分钟
        Date runTime = evenMinuteDate(new Date());

        System.out.println("------- Scheduling Job  -------------------");

        // 定义job
        JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();

        // 定义触发器，每2秒执行一次
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/2 * * * * ?")).build();

        // 将job注册到调度器
        sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + runTime);

        // 启动调度器
        sched.start();

        System.out.println("------- Started Scheduler -----------------");

        // 等待1分钟
        System.out.println("------- Waiting 60 seconds... -------------");
        try {
            Thread.sleep(60L * 1000L);
        } catch (Exception e) {
            //
        }

        // 关闭调度器
        System.out.println("------- Shutting Down ---------------------");
        sched.shutdown(true);
        System.out.println("------- Shutdown Complete -----------------");
    }

    public static void main(String[] args) throws Exception {

        SimpleCronExample example = new SimpleCronExample();
        example.run();

    }

}
