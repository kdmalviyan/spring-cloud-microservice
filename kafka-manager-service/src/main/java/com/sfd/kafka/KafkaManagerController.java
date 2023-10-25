package com.sfd.kafka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author kuldeep
 */
@RestController
@RequestMapping("kafka")
public class KafkaManagerController {

    @GetMapping()
    public ResponseEntity<Mono<KafkaConfigModel>> getKafkaConfigModel() {
        KafkaConfigModel kafkaConfigModel = new KafkaConfigModel(List.of(new KafkaTopic("Testing", 1, LocalDateTime.now())));
        return ResponseEntity.ok(Mono.just(kafkaConfigModel));
    }
}
