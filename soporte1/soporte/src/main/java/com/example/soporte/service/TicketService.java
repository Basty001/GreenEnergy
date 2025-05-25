package com.example.soporte.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.soporte.model.Ticket;
import com.example.soporte.repository.TicketRepository;

import reactor.core.publisher.Mono;


@Service
public class TicketService {
    private final TicketRepository repository;
    private final WebClient usuarioWebClient;

    public TicketService(TicketRepository repository, WebClient usuarioWebClient) {
        this.repository = repository;
        this.usuarioWebClient = usuarioWebClient;
    }

    public Ticket crearTicket(Ticket ticket) {
        if (!verificarUsuarioExistente(ticket.getIdUsuario())) {
            throw new RuntimeException("Usuario con ID " + ticket.getIdUsuario() + " no existe");
        }
        return repository.save(ticket);
    }


        public List<Ticket> buscarPorUsuario(Long idUsuario) {
        // Verifica primero que el usuario exista
        if (!verificarUsuarioExistente(idUsuario)) {
            throw new RuntimeException("Usuario no existe");
        }
        return repository.findByIdUsuario(idUsuario);
    }

    private Boolean verificarUsuarioExistente(Long idUsuario) {
    try {
        Map<String, Object> response = usuarioWebClient.get()
            .uri("/users/{id}", idUsuario)
            .retrieve()
            .onStatus(
                status -> status.is4xxClientError() || status.is5xxServerError(), // <- Corrección clave
                clientResponse -> Mono.error(new RuntimeException("Usuario no encontrado o error del servidor"))
            )
            .bodyToMono(Map.class)
            .block();
        
        return response != null && !response.isEmpty();
    } catch (Exception e) {
        return false;
    }
}
}
