package com.sfd.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author kuldeep
 */
@Data
@AllArgsConstructor
public class KafkaConfigModel {
    private List<KafkaTopic> topics;
}
