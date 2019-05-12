package com.caidi.springbootadvanced.task;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("taskDemo")
public class TaskDemo {

    @Autowired
    private JobOne jobOne;
    public void start() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        System.out.println("scheduler.start");
        JobDetail jobDetail = JobBuilder.newJob(JobOne.class).withIdentity("d1","g1").build();

        //触发时间点. (每5秒执行1次.)
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();



        // 交由Scheduler安排触发

        scheduler.scheduleJob(jobDetail,trigger);



        //睡眠20秒.

        TimeUnit.SECONDS.sleep(20);

        scheduler.shutdown();//关闭定时任务调度器.

        System.out.println("scheduler.shutdown");
    }
}
