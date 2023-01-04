package com.qw4wer.spring.cloud.simple.examples.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("swagger", r -> r.path("/swagger-ui.html").uri("http://localhost:8080/swagger-ui.html"))
                .build();
    }
}