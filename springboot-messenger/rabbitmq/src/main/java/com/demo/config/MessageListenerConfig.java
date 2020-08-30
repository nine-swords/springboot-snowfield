//package com.demo.config;
//
//import com.demo.consumer.AckConsumer;
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MessageListenerConfig {
//
//    @Autowired
//    private CachingConnectionFactory cachingConnectionFactory;
//    @Autowired
//    private AckConsumer ackConsumer;
//
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
//        // RabbitMQ默认是自动确认，这里改为手动确认消息
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        //设置一个队列
//        container.setQueueNames("test_queue_1");
//        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
//        //  container.setQueueNames("TestDirectQueue","TestDirectQueue2","TestDirectQueue3");
//
//        container.setMessageListener(ackConsumer);
//
//        return container;
//    }
//}
