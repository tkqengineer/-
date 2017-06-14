package com.alex.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @classDesc: 功能描述:()
 * @author: 滕康全
 * @createTime: 2017/6/14 09:45:39
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class MyJob extends QuartzJobBean{

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //获取spring 容器
        ApplicationContext applicationContext = (ApplicationContext) context.getMergedJobDataMap().get("applicationContext");
        System.out.println(applicationContext);

    }
}
