package com.caidi.springbootadvanced;


import com.caidi.springbootadvanced.rabbitmqtest.direct.Sender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMqDirect {



    @Resource(name = "direct-sender1")
    private Sender1 directSender1;





    @Test
    public void testDirect() {
        // key1
        directSender1.send1("hello Direct rabbitmq", "direct_key_1");

        // key2
        //directSender1.send2("hello Direct rabbitmq", "direct_key_2");


        // 结果：com.caidi.springbootadvanced.rabbitmqtest.direct.ReceiveImmediate 消费消息： hello Direct rabbitmq
        // key2为什么 能发到key1的队列q6去  ex1交换机绑定的队列q6 q7 ,key1   ex2 交换机绑定的队列q8 ,key2
        //directSender1.send1("hello Direct rabbitmq", "direct_key_2");
    }



}
