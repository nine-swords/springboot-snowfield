package com.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ConsumerDemo {
    /**
     * 定义此消费者接收topics = "demo"的消息
     */
    @KafkaListener(topics = "test")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }
}
