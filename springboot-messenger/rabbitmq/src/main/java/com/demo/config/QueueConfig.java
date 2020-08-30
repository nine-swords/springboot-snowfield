package com.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QueueConfig{

    @Bean
    public Queue queue() {
        Queue queue = new Queue("test_queue_1", true);
        return queue;
    }
    @Bean
    public DirectExchange delayExchange() {

        return new DirectExchange("test_exchange",true,false);
    }


    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(delayExchange()).with("test_queue_1");
    }
}
