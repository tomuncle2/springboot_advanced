package com.caidi.springbootadvanced;


import com.caidi.springbootadvanced.rabbitmqtest.deadLetter.Sender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMqDealy {


    @Resource(name = "deadLetter-sender1")
    private Sender1 deadLetterSender1;


    @Test
    public void testDeadLetter() {

        //topicSender1.send1("hello Topic rabbitmq", "topic_key.test");

        deadLetterSender1.send("hello dealyqu rabbitmq", "immediate.direct_key1");
    }

}
