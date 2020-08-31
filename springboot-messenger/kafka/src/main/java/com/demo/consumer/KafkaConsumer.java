package com.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
 * 所有的consumer可以加入同一个组，竞争同一个topic，消息只会发给组中的一个consumer，由负载均衡决定发给谁，这就是传统的队列模式。
 *
 * 如果consumer在不同的组中，这就成为了发布-订阅模式，消息会被分发到每一个组。
 *
 * 更常见的是，每个topic都有若干数量的consumer组，每个组都可看做一个“订阅者”，由若干个consumer组成，
 * 这其实就是一个发布-订阅模式，只不过订阅者是一组的consumer而不是单个consumer。
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "group1")
    public void listen1 (ConsumerRecord<?, ?> record){
        System.out.println("收到来自主题["+record.topic()+"]的消息："+record.value());
    }

    @KafkaListener(topics = "test", groupId = "group2")
    public void listen2 (ConsumerRecord<?, ?> record){
        System.out.println("收到来自主题["+record.topic()+"]的消息："+record.value());
    }
}
