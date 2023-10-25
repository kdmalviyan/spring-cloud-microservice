package com.sfd.gateway

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayConfig {
    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route("order") { r ->
                r.path("/order/**")
                    .filters { f -> f.stripPrefix(0) }
//                    .uri("http://localhost:8081")
                    .uri("lb://ORDER-SERVICE")  // "ORDER-SERVICE" is the Eureka service name
            }
            .route("inventory") { r ->
                r.path("/inventory/**")
                    .filters { f -> f.stripPrefix(0) }
                    .uri("lb://INVENTORY-SERVICE")  // "INVENTORY-SERVICE" is the Eureka service name
            }
            .route("kafka") { r ->
                r.path("/kafka/**")
                    .filters { f -> f.stripPrefix(0) } // Removing "messaging" from path 
                    .uri("lb://KAFKA-MANAGER")  // "KAFKA-MANAGER" is the Eureka service name
            }
            .route("payment") { r ->
                r.path("/payment/**")
                    .filters { f -> f.stripPrefix(0) }
                    .uri("lb://PAYMENT-SERVICE")  // "PAYMENT-SERVICE" is the Eureka service name
            }
            .build()
    }
}
