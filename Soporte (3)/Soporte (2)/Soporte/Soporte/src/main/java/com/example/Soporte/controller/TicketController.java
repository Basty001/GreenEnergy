package com.example.Soporte.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Soporte.model.TicketSoporte;
import com.example.Soporte.service.SoporteService;

@RestController
@RequestMapping("/api/v1/soporte")
public class TicketController {
    @Autowired
    private SoporteService soporteService;

    //endpoint para obtener todos los Ticket
    @GetMapping
    public ResponseEntity<List<TicketSoporte>> obtenerTicket(){
        List<TicketSoporte> lista = soporteService.getTicket();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    //endpoint para guardar un Ticket nuevo
    @PostMapping
    public ResponseEntity<?> crearTicket(@RequestBody TicketSoporte nuevo){
        try {
            TicketSoporte pedido = soporteService.saveTicket(nuevo);
            return ResponseEntity.status(201).body(pedido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}