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

    //发送主题消息（该消息会发送到topic_exchange交换机的topic1和topic2队列）
    @Test
    public  void  sendTopic1()  {
        rabbitTemplate.convertAndSend("topic_exchange", "test_topic.a", "这是一个主题消息");
    }

    //发送主题消息（该消息只会发送到topic_exchange交换机的topic2队列）
    @Test
    public  void  sendTopic2()  {
        rabbitTemplate.convertAndSend("topic_exchange", "test_topic.abc", "这是另一个主题消息");
    }

    //发送主题消息（该消息会发送到fanout_exchange交换机的所有队列）
    @Test
    public  void  sendFanout()  {
        rabbitTemplate.convertAndSend("fanout_exchange", null, "这是一个扇形主题消息");
    }
}
