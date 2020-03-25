package com.caidi.springbootadvanced.rabbitmqtest.deadLetter;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 16:32 2020/3/21
 * @description: 死信消息消费者
 */
@Component(value = "deadLetter-receiveDeal")
@RabbitListener(queues = RabbitMQConstantTest.DELAY_QUEUE)
public class ReceiveDeal {

    /**
     * 参数的方法重载
     * @date 14:04 2020/3/23
     * @param msg
     * @return void
     */
    @RabbitHandler
    public void receive1(String msg) {
        System.out.println(this.getClass().getName() + " 消费消息： " + msg);
    }
}