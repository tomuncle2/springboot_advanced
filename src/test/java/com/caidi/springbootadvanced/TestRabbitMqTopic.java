package com.caidi.springbootadvanced;


import com.caidi.springbootadvanced.rabbitmqtest.topic.Sender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMqTopic {


    @Resource(name = "topic-sender1")
    private Sender1 topicSender1;


    @Test
    public void testTopic() {

        //topicSender1.send1("hello Topic rabbitmq", "topic_key.test");

        topicSender1.send2("hello fanout rabbitmq", "topic_key.test");
    }

}