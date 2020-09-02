package com.demo.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsOptions;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class KafkaUtil {

    @Autowired
    private AdminClient adminClient;

    // 创建主题
    public  void createTopic(String topic) throws Exception {

        NewTopic newTopic = new NewTopic(topic,2,(short)1);
        adminClient.createTopics(Collections.singleton(newTopic), new CreateTopicsOptions().timeoutMs(10000))
                .all()
                .get();
        adminClient.close();
    }

    // 查询主题列表
    public void queryTopics() throws InterruptedException, ExecutionException, TimeoutException {

        List<String> list = new ArrayList<>();
        adminClient.listTopics()
                .listings()
                .get(1, TimeUnit.MINUTES)
                .forEach(topicListing -> {
                    System.out.println("currentTopic is: " + topicListing.name());
                    list.add(topicListing.name());
                });
    }

    public void deleteTopic(String topic) throws ExecutionException, InterruptedException {

        adminClient.deleteTopics(Collections.singleton(topic))
                .all()
                .get();
    }
}
