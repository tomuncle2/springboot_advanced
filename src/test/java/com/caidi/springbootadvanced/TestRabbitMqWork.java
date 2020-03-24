package com.caidi.springbootadvanced;


import com.caidi.springbootadvanced.rabbitmqtest.work.Sender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMqWork {


    @Resource(name = "work-sender1")
    private Sender1 workSender1;



    @Test
    public void testWork() {
        for (int i = 0 ; i < 10 ; i++) {
            workSender1.send("hello work rabbitmq [" +  i + "]");
        }
    }



}
