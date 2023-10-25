package com.sfd.payments

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("payment")
class PaymentController {

    @GetMapping
    public fun getPaymentDetails(): ResponseEntity<Mono<PaymentDetails>> {
        return ResponseEntity.ok(Mono.just(PaymentDetails("Order-1234", 120.0)))
    }

    @GetMapping("{id}")
    public fun getPaymentById(@PathVariable("id") orderId: String): ResponseEntity<Mono<PaymentDetails>> {
        return ResponseEntity.ok(Mono.just(PaymentDetails(orderId, 11200.0)))
    }
}