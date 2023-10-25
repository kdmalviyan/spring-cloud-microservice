package com.sfd.inventory

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class OrderMessageConsumer {

    @KafkaListener(topics = ["test-topic-kuldeep"], groupId = "inventory-group")
    public fun handleMessage(message: String) {
        println("Message processed: $message")
    }
}