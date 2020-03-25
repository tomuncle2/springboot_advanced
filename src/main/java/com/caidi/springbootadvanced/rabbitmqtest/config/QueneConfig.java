package com.caidi.springbootadvanced.rabbitmqtest.config;

import com.caidi.springbootadvanced.rabbitmqtest.constant.RabbitMQConstantTest;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

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
     * @description //路由交换机1
     * @date 16:08 2020/3/10
     * @param
     * @return org.springframework.amqp.core.Exchange
     */
    @Bean
    public DirectExchange directExchange_2(){
        return new DirectExchange(RabbitMQConstantTest.DIRECT_EXCHANGE_2,true,false);
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
    @Bean(RabbitMQConstantTest.TOPIC_EXCHANGE_1)
    public TopicExchange topicExchange_1(){
        return new TopicExchange(RabbitMQConstantTest.TOPIC_EXCHANGE_1,true,false);
    }

    /**
     * @description //主题交换机2
     * @date 16:07 2020/3/10
     * @param
     * @return org.springframework.amqp.core.Exchange
     */
    @Bean(RabbitMQConstantTest.TOPIC_EXCHANGE_2)
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
        return BindingBuilder.bind(Queue7()).to(directExchange_1()).with(RabbitMQConstantTest.DIRECT_KEY_1);
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
        return BindingBuilder.bind(Queue8()).to(directExchange_2()).with(RabbitMQConstantTest.DIRECT_KEY_2);
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
        return BindingBuilder.bind(Queue9()).to(topicExchange_1()).with(RabbitMQConstantTest.TOPIC_KEY_1);
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
        return BindingBuilder.bind(Queue10()).to(topicExchange_1()).with(RabbitMQConstantTest.TOPIC_KEY_1);
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
        return BindingBuilder.bind(Queue11()).to(topicExchange_2()).with(RabbitMQConstantTest.TOPIC_KEY_3);
    }

    // 创建一个立即消费队列
    @Bean
    public Queue immediateQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(RabbitMQConstantTest.IMMEDIATE_QUEUE, true,false, false);
    }

    // 创建一个死信队列
    @Bean
    public Queue delayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", RabbitMQConstantTest.IMMEDIATE_QUEUE_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", RabbitMQConstantTest.IMMEDIATE_QUEUE_DIRECT_KEY);
        return new Queue(RabbitMQConstantTest.DELAY_QUEUE, true, false, false, params);
    }

    @Bean
    public DirectExchange immediateExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        //第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(RabbitMQConstantTest.IMMEDIATE_QUEUE_EXCHANGE, true, false);
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        // 第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(RabbitMQConstantTest.DELAY_QUEUE_EXCHANGE, true, false);
    }

    @Bean
    // 把立即消费的队列和立即消费的exchange绑定在一起
    public Binding immediateBinding() {
        return BindingBuilder.bind(immediateQueue()).to(immediateExchange()).with(RabbitMQConstantTest.IMMEDIATE_QUEUE_DIRECT_KEY);
    }

    @Bean
    // 把立即消费的队列和立即消费的exchange绑定在一起
    public Binding delayBinding() {
        return BindingBuilder.bind(delayQueue()).to(deadLetterExchange()).with(RabbitMQConstantTest.DELAY_QUEUE_EXCHANGE_DIRECT_KEY);
    }


}