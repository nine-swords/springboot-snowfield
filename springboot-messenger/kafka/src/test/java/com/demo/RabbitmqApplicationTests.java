package com.demo;

import com.demo.config.KafkaUtil;
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
    private KafkaUtil kafkaUtil;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Test
    public void tool() throws Exception {
//        //创建主题
//        kafkaUtil.createTopic("test");
        //查询主题列表
        kafkaUtil.queryTopics();
    }

    @Test
    public void send(){
        kafkaTemplate.send("test", "这是一条消息"); //使用kafka模板发送信息
    }

}
