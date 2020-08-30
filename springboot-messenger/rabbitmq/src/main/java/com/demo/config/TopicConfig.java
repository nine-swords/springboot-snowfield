package com.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicConfig {

    @Bean
    public Queue topicQueue1() {
        return new Queue("test_topic_1");
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue("test_topic_2");
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic_exchange");
    }

    // 主题交换机，这个交换机其实跟直连交换机流程差不多。
    // 当前为test_topic_1和test_topic_2队列绑定同一个交换机和routingKey。
    @Bean
    Binding binding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("test_topic");
    }
    @Bean
    Binding binding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("test_topic");
    }
}
