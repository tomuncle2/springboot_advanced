package com.caidi.springbootadvanced;

import com.caidi.springbootadvanced.config.QuartzConfig;
import com.caidi.springbootadvanced.task.TaskDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Autowired
    private TaskDemo taskDemo;

    @Autowired
    private QuartzConfig quartzConfig;

    @Test
    public void contextLoads() {

//        try {
//            taskDemo.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void contextLoadss() {


    }

}
