package com.sfd.kafka;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.TopicDescription;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * @author kuldeep
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final KafkaAdmin kafkaAdmin;
    public Try<Void> createTopic(final KafkaTopic kafkaTopic) {
        return Try.runRunnable(() -> kafkaAdmin.createOrModifyTopics(kafkaTopic));
    }

    public Map<String, TopicDescription> describe(String topicName) {
        log.info(Objects.toString(kafkaAdmin.getConfigurationProperties()));
        return kafkaAdmin.describeTopics(topicName);
    }
}
