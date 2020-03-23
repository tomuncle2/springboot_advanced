//package com.caidi.springbootadvanced;
//
//import com.caidi.springbootadvanced.config.QuartzConfig;
//import com.caidi.springbootadvanced.rabbitmq.producer.TestoneSend;
//import com.caidi.springbootadvanced.task.TaskDemo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestRabbitMq {
//
//    @Autowired
//    private TestoneSend testoneSend;
//
//
//    @Test
//    public void contextLoadss() {
//        testoneSend.testOneSend("hello rabbitmq");
//    }
//
//    @Test
//    public void contextLoad1() {
//        testoneSend.testOneSend("101");
//    }
//
//    @Test
//    public void contextLoad2() {
//        testoneSend.testOneSend(11);
//    }
//
//}
