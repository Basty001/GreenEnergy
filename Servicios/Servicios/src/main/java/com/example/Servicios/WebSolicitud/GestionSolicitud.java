package com.example.Servicios.WebSolicitud;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GestionSolicitud {
        private final WebClient webclient;

    public GestionSolicitud(@Value("${solicitud-service.url}") String solicitudServiceUrl) {
        this.webclient = WebClient.builder().baseUrl(solicitudServiceUrl).build();
    }

    public Map<String, Object> getSolicitudById(Long id) {
        return this.webclient.get()
            .uri("/{id}", id)
            .retrieve()
            .onStatus(status -> status.is4xxClientError(), response -> response.bodyToMono(String.class)
                .map(body -> new RuntimeException("Solicitud no encontrada")))
            .bodyToMono(Map.class)
            .block();
    }
}


