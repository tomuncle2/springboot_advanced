package com.caidi.springbootadvanced.rabbitmq.producer;

import com.caidi.springbootadvanced.rabbitmq.constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 16:17 2020/3/10
 * @description: 消息发送者one
 */
@Component
public class TestoneSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void testOneSend(Object msg){
        rabbitTemplate.convertAndSend(RabbitMQConstant.QUENE_1, msg);
    }
}