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
        Queue queue = new Queue("test_queue_1", true);
        return queue;
    }
    @Bean
    public DirectExchange delayExchange() {

        return new DirectExchange("queue_exchange",true,false);
    }


    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(delayExchange()).with("test_queue_1");
    }
}
