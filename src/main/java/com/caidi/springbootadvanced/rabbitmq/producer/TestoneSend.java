//package com.caidi.springbootadvanced.rabbitmq.producer;
//
//import com.caidi.springbootadvanced.rabbitmq.constant.RabbitMQConstant;
//import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @author: 蔡迪
// * @date: 16:17 2020/3/10
// * @description: 消息发送者one
// */
//@Component
//public class TestoneSend {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    /**
//    普通方法 queue:customer 1:1(普通) 1:n（work模式）
//     */
//    public void testOneSend(Object msg){
//        rabbitTemplate.convertAndSend(RabbitMQConstant.QUENE_1, msg);
//    }
//
//    /**
//     fanout producer:queue  1:n（fanout模式）
//     */
//    public void testFanoutSend(Object msg){
//        rabbitTemplate.convertAndSend(RabbitMQConstant.FANOUT_EXCHANGE_1,"",msg);
//    }
//
//    /**
//     direct producer:queue  1:n（direct模式）
//     */
//    public void testDirectSend(Object msg){
//        rabbitTemplate.convertAndSend(RabbitMQConstant.DIRECT_EXCHANGE_1,"direct_key_1", msg);
//    }
//
//    /**
//     topic producer:queue  1:n（topic模式）
//     */
//    public void testTopicSend(Object msg){
//        rabbitTemplate.convertAndSend(RabbitMQConstant.TOPIC_EXCHANGE_1, "topic_key.test",msg);
//    }
//
//}