package com.demo.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/*
 * 通过java API 操作kafka中的topic
 */
@Configuration
public class KafkaConfig {

    private static final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";

    @Bean
    public AdminClient adminClient() {

        Properties properties = new Properties();
        // 唯一必须参数
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);

        return AdminClient.create(properties);
    }
}
