package com.example.soporte.webClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;



@Configuration
public class WebClientConfig {
    
    @Value("${usuario.service.url}") // Asegúrate que en application.properties sea: http://localhost:8081/api/v1/Usuario
    private String usuarioServiceUrl;
    
    @Bean
    public WebClient usuarioWebClient(WebClient.Builder builder) {
        return builder
            .baseUrl(usuarioServiceUrl) // URL base SIN el /users al final
            .defaultHeader("Accept", "application/json")
            .build();
    }
}
