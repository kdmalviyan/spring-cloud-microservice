package com.sfd.kafka;

import lombok.*;
import org.apache.kafka.clients.admin.NewTopic;

import java.time.LocalDateTime;

/**
 * @author kuldeep
 */
@Getter
@Setter
public class KafkaTopic extends NewTopic {
    private String topicName;
    private int numberOfPartition;
    private LocalDateTime createdAt;
    private int replicationFactor;

    public KafkaTopic(String topicName, int numberOfPartition, int replicationFactor) {
        super(topicName, numberOfPartition, (short) replicationFactor);
        this.topicName = topicName;
        this.numberOfPartition = numberOfPartition;
        this.replicationFactor = replicationFactor;
        this.createdAt = LocalDateTime.now();
    }
}
