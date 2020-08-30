package com.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig{

    @Bean
    public Queue queue() {
        return new Queue("test_queue_1");
    }

    // 直连型交换机，根据交换机name和routingKey将消息投递给对应队列(test_queue_1)。
    @Bean
    public DirectExchange directExchange() {

        return new DirectExchange("queue_exchange",true,false);
    }

    //将test_queue_1队列绑定到queue_exchange交换机
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("test_queue_1");
    }
}
