package com.caidi.springbootadvanced.rabbitmqtest.topic;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 16:31 2020/3/21
 * @description: 生产者1
 */
@Component("topic-sender1")
@Slf4j
public class Sender1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void rec1(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConstantTest.TOPIC_EXCHANGE_1,"topic_key.1", msg);
        log.warn(this.getClass().getName() + " 生产消息： " + msg);
    }

    public void rec2(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConstantTest.TOPIC_EXCHANGE_2,"topic_key.test", msg);
        log.warn(this.getClass().getName() + " 生产消息： " + msg);
    }

}