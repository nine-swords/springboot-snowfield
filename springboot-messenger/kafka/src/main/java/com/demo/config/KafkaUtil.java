package com.demo.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsOptions;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
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
    }

    // 显示所有主题
    public void listTopics() throws InterruptedException, ExecutionException, TimeoutException {

        adminClient.listTopics()
                .listings()
                .get(1, TimeUnit.MINUTES)
                .forEach(topicListing -> System.out.println("currentTopic is: " + topicListing.name()));
    }

    // 查询主题
    public void describeTopic(String name) throws ExecutionException, InterruptedException {

        adminClient.describeTopics(Collections.singleton(name))
                .all()
                .get()
                .forEach((k,v) -> System.out.println(k+ " ===> " + v));
    }

    //windows下调用此方法会报找不到日志文件的错
    public void deleteTopic(String topic) throws ExecutionException, InterruptedException {

        adminClient.deleteTopics(Collections.singleton(topic))
                .all()
                .get();
    }
}
