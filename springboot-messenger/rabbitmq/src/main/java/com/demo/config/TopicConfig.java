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
        return new Queue("topic1");
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue("topic2");
    }

    /*
     * 主题交换机，这个交换机其实跟直连交换机流程差不多。
     * 该类型的交换器将所有发送到Topic Exchange的消息转发到所有RoutingKey指定的Topic的队列上面。
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic_exchange");
    }

    /*
     * 主题为test_topic.a的消息都会被发送到topic_exchange交换机的topic1队列,
     * 由于test_topic.a也是以test_topic.开头的，所以该主题消息还会被发送到topic2队列。
     */
    @Bean
    Binding binding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("test_topic.a");
    }
    /*
     * 使用主题交换机需要遵循其主题命名规则：以‘.’号分割字符串。
     * ‘#’号为通配符，匹配0或多个字符，‘*’号匹配一个字符。
     * 当前表示以test_topic.开头的主题消息都会被发送到topic_exchange交换机的topic2队列
     */
    @Bean
    Binding binding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("test_topic.#");
    }
}
