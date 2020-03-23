package com.caidi.springbootadvanced.rabbitmqtest.direct;

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
@Component("direct-sender1")
@Slf4j
public class Sender1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConstantTest.DIRECT_EXCHANGE_1,RabbitMQConstantTest.DIRECT_KEY_1, msg);
        log.warn(this.getClass().getName() + " 生产消息： " + msg);
    }

    public void send2(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConstantTest.DIRECT_EXCHANGE_2,RabbitMQConstantTest.DIRECT_KEY_2, msg);
        log.warn(this.getClass().getName() + " 生产消息： " + msg);
    }
}