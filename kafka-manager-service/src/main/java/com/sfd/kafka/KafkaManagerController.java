package com.sfd.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.TopicDescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author kuldeep
 */
@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class KafkaManagerController {
    private final KafkaService kafkaService;
    @GetMapping("{topicName}")
    public ResponseEntity<Mono<Map<String, TopicDescription>>> describeTopic(@PathVariable("topicName") String topicName) {
        return ResponseEntity.ok(Mono.just(kafkaService.describe(topicName)));
    }

    @PostMapping()
    public ResponseEntity<Mono<?>> create(@RequestBody KafkaTopic kafkaTopic) {
        kafkaService.createTopic(kafkaTopic)
                .getOrElseThrow((e) -> new RuntimeException("topic creation " + e.getStackTrace()));
        return ResponseEntity.ok(Mono.just(kafkaTopic));
    }
}
