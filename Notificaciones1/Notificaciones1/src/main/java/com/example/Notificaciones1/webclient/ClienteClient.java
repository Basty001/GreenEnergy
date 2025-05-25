package com.example.Notificaciones1.webclient;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class ClienteClient {

    private final WebClient webClient;

    public ClienteClient(@Value("${cliente-service.url}") String clienteServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(clienteServiceUrl)
                .build();
    }

    public Map<String, Object> getClienteById(Long id) {
        try {
            return this.webClient.get()
                    .uri("/{id}", id)
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError(), 
                            response -> Mono.error(new RuntimeException("Cliente no encontrado")))
                    .bodyToMono(Map.class)
                    .block();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al validar cliente: " + e.getMessage());
        }
    }
}