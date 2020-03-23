package com.caidi.springbootadvanced.rabbitmqtest.work;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 16:33 2020/3/21
 * @description: 消费者2
 */
@Component(value = "work-receive2")
@RabbitListener(queues = RabbitMQConstantTest.QUENE_2)
public class Receive2 {

    /**
     * 参数的方法重载
     * @date 14:04 2020/3/23
     * @param msg
     * @return void
     */
    @RabbitHandler
    public void receive2(String msg) {
        System.out.println(this.getClass().getName() + " 消费消息： " + msg);
    }
}