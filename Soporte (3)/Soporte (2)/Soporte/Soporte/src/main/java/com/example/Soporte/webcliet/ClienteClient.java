package com.example.Soporte.webcliet;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ClienteClient {

    //variable para la comunicación
    private final WebClient webclient;

    //metodo constructor de la clase
    public ClienteClient(@Value("${cliente-service.url}") String clienteServiceUrl){
        this.webclient = WebClient.builder().baseUrl(clienteServiceUrl).build();

    }
    //metodo para comunicarnos con el microservicio de cliente
    //y buscar si un cliente existe mediante su id
    public Map<String, Object> getClienteById(Long id){
        return this.webclient.get()
        .uri("/{id}",id).retrieve()
        .onStatus(status -> status.is4xxClientError(), response -> response.bodyToMono(String.class)
        .map(body -> new RuntimeException("Cliente no encontrado"))).bodyToMono(Map.class).block();
    }



}