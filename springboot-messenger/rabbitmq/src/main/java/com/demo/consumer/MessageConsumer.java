package com.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public  class MessageConsumer {

    @RabbitListener(queues  =  "test_queue_1")
    public  void  queue(String  msg)  {
        System.out.println("消息接收时间:"+new  Date());
        System.out.println("接收到的消息:"+msg);
    }

    //定义两个主题消费者监听两个队列中的消息
    @RabbitListener(queues = "topic1")
    public void topic1(String  msg) {
        System.out.println("消息接收时间:"+new  Date());
        System.out.println("topic1()接收到的消息:"+msg);
    }
    @RabbitListener(queues = "topic2")
    public void topic2(String  msg) {
        System.out.println("消息接收时间:"+new  Date());
        System.out.println("topic2()接收到的消息:"+msg);
    }

    //定义两个主题消费者监听两个队列中的消息
    @RabbitListener(queues = "fanout1")
    public void fanout1(String  msg) {
        System.out.println("消息接收时间:"+new  Date());
        System.out.println("fanout1()接收到的消息:"+msg);
    }
    @RabbitListener(queues = "fanout2")
    public void fanout2(String  msg) {
        System.out.println("消息接收时间:"+new  Date());
        System.out.println("fanout2()接收到的消息:"+msg);
    }
}
