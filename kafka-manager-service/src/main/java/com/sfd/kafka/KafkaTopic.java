package com.sfd.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kuldeep
 */
@Data
@AllArgsConstructor
public class KafkaTopic {
    private String topicName;
    private int numberOfPartition;
    private LocalDateTime createdAt;
}
