package com.dni_ai_ocr.gateway.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig {

    // Swagger 문서 기본 정보 설정
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Taehwa API")
                        .version("v1.0.0")
                        .description("Taehwa 서비스 API 명세서")
                        .contact(new Contact()
                                .name("Taehwa Dev Team")
                                .email("support@taehwa.com")
                        )
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }

    @Bean
    public List<AbstractSwaggerUiConfigProperties.SwaggerUrl> swaggerUrls() {
        return Arrays.asList(
                new AbstractSwaggerUiConfigProperties.SwaggerUrl("FastAPI", "/fastapi/openapi.json", "fastapi"),
                new AbstractSwaggerUiConfigProperties.SwaggerUrl("Spring", "/spring-api-docs/v3/api-docs", "spring")
        );
    }

}
