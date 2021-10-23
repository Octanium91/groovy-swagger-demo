package com.groovy.swagger.groovyswaggerdemo

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {


    @Bean
    GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("localhost")
                .pathsToMatch("/**")
                .build()
    }

    @Bean
    OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("Groovy Swagger Demo")
                .version("v1 (demo)")
                .description("Usage example swagger for Groovy (java)")
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.org"))
                .contact(new Contact().name("octanium91")
                        .email("octanium91@gmail.com")))
                .servers(List.of(new Server().url("http://localhost:9666/")
                        .description("localhost server")))
    }

}