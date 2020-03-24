package com.caidi.springbootadvanced;


import com.caidi.springbootadvanced.rabbitmqtest.fanout.Sender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMqFanout {



    @Resource(name = "fanout-sender1")
    private Sender1 fanoutSender1;


    @Test
    public void testFanout() {

        fanoutSender1.send("hello fanout rabbitmq");
    }


}
