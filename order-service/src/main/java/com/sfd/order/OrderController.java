package com.sfd.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author kuldeep
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @GetMapping
    public ResponseEntity<Flux<Order>> getAll() {
        return ResponseEntity.ok(Flux.fromIterable(List.of(new Order("order-1234", "Kuldeep"))));
    }
}
