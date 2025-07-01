package com.dni_ai_ocr.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerRoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // FastAPI OpenAPI route
                .route("fastapi-openapi", r -> r.path("/api/fastapi/openapi.json")
                        .filters(f -> f.rewritePath("/api/fastapi/openapi.json", "/openapi.json"))
                        .uri("http://localhost:8000"))


                // Spring WAS API docs route
                .route("spring-api-docs", r -> r.path("/api/spring/v3/api-docs")
                        .filters(f -> f.rewritePath("/api/spring/v3/api-docs", "/v3/api-docs"))
                        .uri("http://localhost:8081"))

                .build();
    }
}
