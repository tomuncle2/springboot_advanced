package com.caidi.springbootadvanced.rabbitmqtest.config;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 蔡迪
 * @date: 15:43 2020/3/10
 * @description: 队列配置
 */
@Configuration
public class QueneConfig {


    /**
     * @description //队列1
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue1(){
        return new Queue(RabbitMQConstantTest.QUENE_1, true, false,false);
    }

    /**
     * @description //队列2
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue2(){
        return new Queue(RabbitMQConstantTest.QUENE_2, true, false,false);
    }

    /**
     * @description //队列3
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue3(){
        return new Queue(RabbitMQConstantTest.QUENE_3, true, false,false);
    }

    /**
     * @description //队列4(普通队列)
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue4(){
        return new Queue(RabbitMQConstantTest.QUENE_1, true, false,false);
    }

    /**
     * @description //路由交换机1
     * @date 16:08 2020/3/10
     * @param
     * @return org.springframework.amqp.core.Exchange
     */
    @Bean
    public DirectExchange directExchange_1(){
        return new DirectExchange(RabbitMQConstantTest.DIRECT_EXCHANGE_1,true,false);
    }

    /**
     * @description //广播交换机1
     * @date 16:08 2020/3/10
     * @param
     * @return org.springframework.amqp.core.Exchange
     */
    @Bean
    public FanoutExchange fanoutExchange_1(){
        return new FanoutExchange(RabbitMQConstantTest.FANOUT_EXCHANGE_1,true,false);
    }

    /**
     * @description //主题交换机1
     * @date 16:07 2020/3/10
     * @param
     * @return org.springframework.amqp.core.Exchange
     */
    @Bean
    public TopicExchange topicExchange_1(){
        return new TopicExchange(RabbitMQConstantTest.TOPIC_EXCHANGE_1,true,false);
    }

    @Bean
    public Binding directExchangeBinding(){
        //BindingBuilder
        //return BindingBuilder.bind(Queue1()).to(directExchange_1()).w(RabbitMQConstant.DIRECT_KEY_1);
        return BindingBuilder.bind(Queue1()).to(directExchange_1()).with(RabbitMQConstantTest.DIRECT_KEY_1);
    }
}