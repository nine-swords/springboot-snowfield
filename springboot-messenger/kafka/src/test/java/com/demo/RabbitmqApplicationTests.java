package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public  class RabbitmqApplicationTests {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Test
    public void send(){
        kafkaTemplate.send("test", "这是一条消息"); //使用kafka模板发送信息
    }
}
