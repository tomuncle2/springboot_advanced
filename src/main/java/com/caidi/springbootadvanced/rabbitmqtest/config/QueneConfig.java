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
     * @description //普通 队列1
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue1(){
        return new Queue(RabbitMQConstantTest.QUENE_1, true, false,false);
    }

    /**
     * @description //work 队列1
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue2(){
        return new Queue(RabbitMQConstantTest.QUENE_2, true, false,false);
    }

    /**
     * @description //fanout队列1
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue3(){
        return new Queue(RabbitMQConstantTest.QUENE_3, true, false,false);
    }

    /**
     * @description //fanout队列2
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue4(){
        return new Queue(RabbitMQConstantTest.QUENE_4, true, false,false);
    }

    /**
     * @description //fanout队列3
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue5(){
        return new Queue(RabbitMQConstantTest.QUENE_5, true, false,false);
    }

    /**
     * @description //direct队列1
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue6(){
        return new Queue(RabbitMQConstantTest.QUENE_6, true, false,false);
    }

    /**
     * @description //direct队列2
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue7(){
        return new Queue(RabbitMQConstantTest.QUENE_7, true, false,false);
    }

    /**
     * @description //direct队列3
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue8(){
        return new Queue(RabbitMQConstantTest.QUENE_8, true, false,false);
    }

    /**
     * @description //topic队列1
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue9(){
        return new Queue(RabbitMQConstantTest.QUENE_9, true, false,false);
    }

    /**
     * @description //topic队列2
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue10(){
        return new Queue(RabbitMQConstantTest.QUENE_10, true, false,false);
    }

    /**
     * @description //topic队列3
     * @param
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue Queue11(){
        return new Queue(RabbitMQConstantTest.QUENE_11, true, false,false);
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
     * @description //主题交换机1 可以序列化到磁盘 配置参数
     * @date 16:07 2020/3/10
     * @param
     * @return org.springframework.amqp.core.Exchange
     */
    @Bean
    public TopicExchange topicExchange_1(){
        return new TopicExchange(RabbitMQConstantTest.TOPIC_EXCHANGE_1,true,false);
    }

    /**
     * @description //主题交换机2
     * @date 16:07 2020/3/10
     * @param
     * @return org.springframework.amqp.core.Exchange
     */
    @Bean
    public TopicExchange topicExchange_2(){
        return new TopicExchange(RabbitMQConstantTest.TOPIC_EXCHANGE_2,true,false);
    }


    /**
     * 绑定队列到 fanout交换机1
     * @date 15:14 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding fanoutExchangeBinding1() {
        return  BindingBuilder.bind(Queue3()).to(fanoutExchange_1());
    }

    /**
     * 绑定队列到 fanout交换机2
     * @date 15:14 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding fanoutExchangeBinding2() {
        return  BindingBuilder.bind(Queue4()).to(fanoutExchange_1());
    }


    /**
     * 绑定队列到 fanout交换机3
     * @date 15:14 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding fanoutExchangeBinding3() {
        return  BindingBuilder.bind(Queue5()).to(fanoutExchange_1());
    }

    /**
     * 绑定队列到 direct交换机1
     * @date 14:49 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding directExchangeBinding1(){
        //BindingBuilder
        //return BindingBuilder.bind(Queue1()).to(directExchange_1()).w(RabbitMQConstant.DIRECT_KEY_1);
        return BindingBuilder.bind(Queue6()).to(directExchange_1()).with(RabbitMQConstantTest.DIRECT_KEY_1);
    }

    /**
     * 绑定队列到 direct交换机1
     * @date 14:49 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding directExchangeBinding2(){
        //BindingBuilder
        //return BindingBuilder.bind(Queue1()).to(directExchange_1()).w(RabbitMQConstant.DIRECT_KEY_1);
        return BindingBuilder.bind(Queue6()).to(directExchange_1()).with(RabbitMQConstantTest.DIRECT_KEY_1);
    }


    /**
     * 绑定队列到 direct交换机1
     * @date 14:49 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding directExchangeBinding3(){
        //BindingBuilder
        //return BindingBuilder.bind(Queue1()).to(directExchange_1()).w(RabbitMQConstant.DIRECT_KEY_1);
        return BindingBuilder.bind(Queue6()).to(directExchange_1()).with(RabbitMQConstantTest.DIRECT_KEY_2);
    }


    /**
     * 绑定队列到 topic交换机1
     * @date 14:49 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding topicExchangeBinding1(){
        //BindingBuilder
        //return BindingBuilder.bind(Queue1()).to(directExchange_1()).w(RabbitMQConstant.DIRECT_KEY_1);
        return BindingBuilder.bind(Queue6()).to(directExchange_1()).with(RabbitMQConstantTest.TOPIC_KEY_1);
    }

    /**
     * 绑定队列到 topic交换机2
     * @date 14:49 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding topicExchangeBinding2(){
        //BindingBuilder
        //return BindingBuilder.bind(Queue1()).to(directExchange_1()).w(RabbitMQConstant.DIRECT_KEY_1);
        return BindingBuilder.bind(Queue6()).to(directExchange_1()).with(RabbitMQConstantTest.TOPIC_KEY_2);
    }


    /**
     * 绑定队列到 topic交换机3
     * @date 14:49 2020/3/23
     * @param
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding topicExchangeBinding3(){
        //BindingBuilder
        //return BindingBuilder.bind(Queue1()).to(directExchange_1()).w(RabbitMQConstant.DIRECT_KEY_1);
        return BindingBuilder.bind(Queue6()).to(directExchange_1()).with(RabbitMQConstantTest.TOPIC_KEY_3);
    }
}