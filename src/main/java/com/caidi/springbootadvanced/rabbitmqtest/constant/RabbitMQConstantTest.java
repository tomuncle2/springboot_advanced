package com.caidi.springbootadvanced.rabbitmqtest.constant;

/**
 * @author: 蔡迪
 * @date: 17:10 2020/3/9
 * @description: 常变量
 */
public class RabbitMQConstantTest {
    // simple-队列1 业务 + 模式 + 数字（子业务模块）
    public static final String QUENE_1 = "simple_q1";
    // work-队列1
    public static final String QUENE_2 = "work_q1";

    // 队列3
    public static final String QUENE_3 = "fanout_q1";
    // 队列4
    public static final String QUENE_4 = "fanout_q2";
    // 队列4
    public static final String QUENE_5 = "fanout_q3";

    // 队列4
    public static final String QUENE_6 = "direct_q1";
    // 队列4
    public static final String QUENE_7 = "direct_q2";
    // 队列4
    public static final String QUENE_8 = "direct_q3";

    // 队列4
    public static final String QUENE_9 = "topic_q1";
    // 队列4
    public static final String QUENE_10 = "topic_q2";
    // 队列4
    public static final String QUENE_11 = "topic_q3";

    // 主题-交换机1（通配符）-交换机1
    public static final String TOPIC_EXCHANGE_1 = "topic_ex_1";
    // 广播-交换机1
    public static final String FANOUT_EXCHANGE_1 = "fanout_ex_1";
    // 路由-交换机1
    public static final String DIRECT_EXCHANGE_1 = "direct_ex_1";

    // 主题key1
    public static final String TOPIC_KEY_1 = "topic_key.#";
    // 路由key
    public static final String DIRECT_KEY_1 = "direct_key_1";
    // 主题key2
    public static final String TOPIC_KEY_2 = "topic_key.*";
    // 主题key3
    public static final String TOPIC_KEY_3 = "topic_key.test";
}