package com.caidi.springbootadvanced.rabbitmqtest.deadLetter;

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
@Component(value = "deadLetter-sender1")
@Slf4j
public class Sender1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 设置消息过期时间
     * @date 15:48 2020/3/24
     * @param msg
     * @return void
     */
    public void send(String msg, String key) {
        rabbitTemplate.convertAndSend(RabbitMQConstantTest.DELAY_QUEUE_EXCHANGE,key,msg, message -> {
            // 过期时间10000毫秒
            message.getMessageProperties().setExpiration("1000");
            return message;
        });
        log.warn(this.getClass().getName() + " 生产消息： " + msg);
    }
}