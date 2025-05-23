package com.example.Soporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Soporte.model.TicketSoporte;
import com.example.Soporte.service.SoporteService;

@RestController
@RequestMapping("/soporte")
public class SoporteController {
    @Autowired
    private SoporteService soporteService;

    @PostMapping("/tickets")
    public TicketSoporte crearTicket(@RequestBody TicketSoporte ticket) {
        return soporteService.crearTicket(ticket);
    }
}
