package com.caidi.springbootadvanced.config;


import com.caidi.springbootadvanced.task.TestQuarzt;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
//    @Bean
//    public JobDetail teatQuartzDetail(){
//        return JobBuilder.newJob(TestQuarzt.class).withIdentity("testQuartz").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger testQuartzTrigger(){
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(10)  //设置时间周期单位秒
//                .repeatForever();
//        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
//                .withIdentity("testQuartz")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }

    @Bean
    public JobDetail myTaskDetail() {
        return JobBuilder.newJob(TestQuarzt.class).withIdentity("myTask2").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(myTaskDetail()).withIdentity("myTask2")
                .withSchedule(scheduleBuilder).build();
    }


}
