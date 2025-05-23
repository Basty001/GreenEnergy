package com.example.Soporte.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Soporte.model.TicketSoporte;
import com.example.Soporte.repository.TicketSoporteRepository;

@Service
public class SoporteService {
    @Autowired
    private TicketSoporteRepository ticketRepository;

    public TicketSoporte crearTicket(TicketSoporte ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setEstado("ABIERTO");
        return ticketRepository.save(ticket);
    }
}
