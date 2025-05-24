package com.example.Soporte.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Soporte.model.TicketSoporte;
import com.example.Soporte.repository.TicketSoporteRepository;
import com.example.Soporte.webcliet.ClienteClient;

@Service
public class SoporteService {
    
    @Autowired
    private TicketSoporteRepository ticketSoporteRepository;

    @Autowired
    private ClienteClient clienteClient;

    //metodo para obtener todos los pedidos
    public List<TicketSoporte> getTicket(){
        return ticketSoporteRepository.findAll();
    }

    // Método para guardar un nuevo ticket
    public TicketSoporte saveTicket(TicketSoporte nuevoTicket) {
        // Verificar si el cliente existe
        Map<String, Object> cliente = clienteClient.getClienteById(nuevoTicket.getClienteId());
        if (cliente == null || cliente.isEmpty()) {
            throw new RuntimeException("Cliente no encontrado. No se puede guardar el ticket");
        }
        return ticketSoporteRepository.save(nuevoTicket);
    }
}

//getClienteById(nuevoTicket.getClienteId());