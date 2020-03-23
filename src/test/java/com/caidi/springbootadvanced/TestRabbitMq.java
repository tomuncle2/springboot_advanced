package com.caidi.springbootadvanced;


import com.caidi.springbootadvanced.rabbitmqtest.simple.Sender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMq {

    @Resource(name = "simple-sender1")
    private Sender1 simpleSender1;


    @Test
    public void testSimple() {
        simpleSender1.send("hello simple rabbitmq");
    }


}
