package com.sfd.inventory

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("inventory")
class InventoryController {
    @GetMapping
    fun getAll(): ResponseEntity<Flux<Product>> {
        return ResponseEntity.ok(Flux.fromIterable(listOf(Product("Phone",
            "IPhone 14, " +
                    "manufactured in India",
            123000.0,
            "number"))))
    }
}