package com.demo;

import com.demo.config.KafkaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@SpringBootTest
@RunWith(SpringRunner.class)
public  class RabbitmqApplicationTests {

    @Autowired
    private KafkaConfig kafkaConfig;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Test
    public void tool() throws InterruptedException, ExecutionException, TimeoutException {
//        kafkaUtil.createTopic("test");
        kafkaConfig.queryTopics();
    }

    @Test
    public void send(){
        kafkaTemplate.send("test", "这是一条消息"); //使用kafka模板发送信息
    }

}
