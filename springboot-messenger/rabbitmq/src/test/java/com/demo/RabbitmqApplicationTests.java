package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public  class  RabbitmqApplicationTests  {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发送队列消息
    @Test
    public  void  sendQueue()  {
        rabbitTemplate.convertAndSend("queue_exchange","test_queue_1","这是一个队列消息");
    }

    //发送主题消息
    @Test
    public  void  sendTopic()  {
        rabbitTemplate.convertAndSend("topic_exchange", "test_topic", "这是一个主题消息");
    }
}
