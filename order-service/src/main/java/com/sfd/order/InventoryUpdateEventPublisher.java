package com.sfd.order;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author kuldeep
 */
@Service
@AllArgsConstructor
public class InventoryUpdateEventPublisher {
    private KafkaTemplate kafkaTemplate;

    public void publish(final Order order) {
        kafkaTemplate.send("test-topic-kuldeep", order.toString());
    }
}
