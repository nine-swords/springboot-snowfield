package com.demo.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public  class  MessageReceiver  {

    @RabbitListener(queues  =  "test_queue_1")
    public  void  receive(String  msg)  {
        System.out.println("消息接收时间:"+new  Date());
        System.out.println("接收到的消息:"+msg);
    }

    @RabbitListener(queues = "test_topic_1")
    public void process(String  msg) {
        System.out.println("消息接收时间:"+new  Date());
        System.out.println("接收到的消息:"+msg);
    }
}
