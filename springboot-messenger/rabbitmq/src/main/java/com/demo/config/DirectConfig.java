package com.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    @Bean
    public Queue queue() {
        return new Queue("test_queue_1");
    }

    /*
     * 直连型交换机
     * 该类型的交换器将所有发送到该交换器的消息转发到RoutingKey指定的队列中，
     * 也就是说路由到BindingKey和RoutingKey完全匹配的队列中。
     */
    @Bean
    public DirectExchange directExchange() {

        return new DirectExchange("queue_exchange",true,false);
    }

    /*
     * 主题为test_queue_1的消息都会被发送到queue_exchange交换机的test_queue_1队列。
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("test_queue_1");
    }
}
