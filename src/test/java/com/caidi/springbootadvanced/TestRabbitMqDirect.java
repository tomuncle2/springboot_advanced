package com.caidi.springbootadvanced;


import com.caidi.springbootadvanced.rabbitmqtest.simple.Sender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMqDirect {

    @Resource(name = "simple-sender1")
    private Sender1 simpleSender1;

    @Resource(name = "work-sender1")
    private Sender1 workSender1;

    @Resource(name = "fanout-sender1")
    private Sender1 fanoutSender1;

    @Resource(name = "direct-sender1")
    private Sender1 directSender1;

    @Resource(name = "topic-sender1")
    private Sender1 topicSender1;

    @Test
    public void testSimple() {
        simpleSender1.send("hello simple rabbitmq");
    }

    @Test
    public void testWork() {
        workSender1.send("hello work rabbitmq");
    }

    @Test
    public void testFanout() {
        fanoutSender1.send("hello fanout rabbitmq");
    }

    @Test
    public void testDirect() {
        fanoutSender1.send("hello fanout rabbitmq");
    }

    @Test
    public void testTopic() {
        fanoutSender1.send("hello fanout rabbitmq");
    }

}
