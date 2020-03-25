package com.caidi.springbootadvanced.rabbitmqtest.deadLetter;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author: 蔡迪
 * @date: 16:32 2020/3/21
 * @description: 即时消费者
 */
@Component(value = "ReceiveImmediate")
@RabbitListener(queues = RabbitMQConstantTest.IMMEDIATE_QUEUE)
public class ReceiveImmediate {

    /**
     * 参数的方法重载
     * @date 14:04 2020/3/23
     * @param msg
     * @return void
     */
    @RabbitHandler
    public void receive1(String msg) {
        System.out.println(new Timestamp(System.currentTimeMillis()).toString());
        System.out.println( this.getClass().getName() + " 消费消息： " + msg);
    }
}