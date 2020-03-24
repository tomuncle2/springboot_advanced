package com.caidi.springbootadvanced.rabbitmqtest.direct;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 16:33 2020/3/21
 * @description: 消费者3
 */
@Component("direct-receive3")
@RabbitListener(queues = RabbitMQConstantTest.QUENE_8)
public class Receive3 {
    /**
     * 参数的方法重载
     * @date 14:04 2020/3/23
     * @param msg
     * @return void
     */
    @RabbitHandler
    public void test(String msg) {
        System.out.println(this.getClass().getName() + " 消费消息： " + msg);
    }
}