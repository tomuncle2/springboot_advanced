package com.caidi.springbootadvanced.rabbitmq.customer;

import com.caidi.springbootadvanced.rabbitmq.constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 16:19 2020/3/10
 * @description: 业务1消息消费者
 */
@Component
@RabbitListener(queues = RabbitMQConstant.QUENE_1)
public class TestoneReceive {

    @RabbitHandler
    public void testOneSend(String msg){
        System.out.println("接收消息 " + msg);
    }

    @RabbitHandler
    public void testOneSend(Integer msg){
        System.out.println("接收消息 " + msg);
    }
}