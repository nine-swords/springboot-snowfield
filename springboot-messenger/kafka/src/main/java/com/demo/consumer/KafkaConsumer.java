package com.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test")
    public void listen1 (ConsumerRecord<?, ?> record){
        System.out.println("收到来自主题["+record.topic()+"]的消息："+record.value());
    }

}
