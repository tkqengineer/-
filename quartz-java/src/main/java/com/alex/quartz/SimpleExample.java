package com.alex.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SimpleExample {

    public  void run() throws SchedulerException {
        System.out.println("------- Initializing ----------------------");



        // 定义调度器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        System.out.println("------- Initialization Complete -----------");

        // 获取当前时间的下一分钟
        Date runTime = evenMinuteDate(new Date());

        System.out.println("------- Scheduling Job  -------------------");

        // 定义job
        // 在quartz中，有组的概念，组+job名称 唯一的
        JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();

        // 定义触发器，在下一分钟启动
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

        // 将job注册到调度器
        sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + runTime);

        // 启动调度器
        sched.start();

        System.out.println("------- Started Scheduler -----------------");

        // 等待65秒
        System.out.println("------- Waiting 65 seconds... -------------");
        try {
            // wait 65 seconds to show job
            Thread.sleep(130L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }

        // 关闭调度器
        System.out.println("------- Shutting Down ---------------------");
        sched.shutdown(true);
        System.out.println("------- Shutdown Complete -----------------");
    }


    public static void main(String[] args) throws SchedulerException {
        SimpleExample simpleExample = new SimpleExample();
        simpleExample.run();
    }

}
