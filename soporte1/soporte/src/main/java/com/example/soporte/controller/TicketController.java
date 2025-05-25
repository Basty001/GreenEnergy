package com.example.soporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.soporte.model.Ticket;
import com.example.soporte.service.TicketService;



@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public Ticket crearTicket(@RequestBody Ticket ticket) {
        return service.crearTicket(ticket);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Ticket> listarPorUsuario(@PathVariable Long idUsuario) {
        return service.buscarPorUsuario(idUsuario);
    }


    /*@GetMapping("/usuario/{idUsuario}")
    public List<Ticket> listarPorUsuario(@PathVariable Long idUsuario) {
        return service.buscarPorUsuario(idUsuario);
    } */
}
