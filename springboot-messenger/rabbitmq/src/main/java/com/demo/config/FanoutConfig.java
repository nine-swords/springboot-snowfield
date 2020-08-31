package com.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout2");
    }

    /*
     * fanout类型的Exchange路由规则非常简单，它会把所有发送到该Exchange的消息路由到所有与它绑定的Queue中。
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_exchange");
    }

    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

}
