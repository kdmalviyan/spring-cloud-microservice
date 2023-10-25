package com.sfd.kafka.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kuldeep
 */
@Configuration
@RequiredArgsConstructor
public class BeansConfig {
    private final KafkaConfig kafkaConfig;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
        KafkaAdmin kafkaAdmin = new KafkaAdmin(configMap);
        kafkaAdmin.setAutoCreate(true);
        return kafkaAdmin;
    }
}
