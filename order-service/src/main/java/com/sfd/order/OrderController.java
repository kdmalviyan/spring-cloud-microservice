package com.sfd.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author kuldeep
 */
@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final InventoryUpdateEventPublisher inventoryUpdateEventPublisher;
    @GetMapping
    public ResponseEntity<Flux<Order>> getAll() {
        return ResponseEntity.ok(Flux.fromIterable(List.of(new Order("order-1234", "Kuldeep"))));
    }

    @PostMapping
    public ResponseEntity<Flux<Order>> createOrder(@RequestBody Order order) {
        inventoryUpdateEventPublisher.publish(order);
        return ResponseEntity.ok(Flux.fromIterable(List.of(order)));
    }
}
