package com.caidi.springbootadvanced.rabbitmqtest.simple;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 16:31 2020/3/21
 * @description: 生产者1
 */
@Component
public class Sender1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public  void send(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConstantTest.QUENE_1, msg);
    }
}