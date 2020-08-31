package com.demo.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsOptions;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * 通过java API 操作kafka中的topic
 */
@Configuration
public class KafkaConfig {

    private static final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";

    private AdminClient adminClient;

    @Bean
    public AdminClient adminClient() {

        Properties properties = new Properties();
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        adminClient = AdminClient.create(properties);

        return adminClient;
    }

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
