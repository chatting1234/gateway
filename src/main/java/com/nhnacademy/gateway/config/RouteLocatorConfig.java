package com.nhnacademy.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder) {

        RouteLocator build = builder.routes().build();

        return builder.routes()
            .route("user_api",
                p -> p.path("/").and()
                    .uri("lb://CHAT-SERVICE")
            )
            .route("chat_api",
                p-> p.path("/").and().weight("account", 50).uri("")
            )
            .route("board_api",
                p-> p.path("/").and().weight("account", 50).uri("")
            ).build();

    }
}
