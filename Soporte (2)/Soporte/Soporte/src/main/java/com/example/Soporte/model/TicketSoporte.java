package com.example.Soporte.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TicketSoporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String estado; // "ABIERTO", "EN_PROCESO", "CERRADO"
    private LocalDateTime fechaCreacion;
    private Long usuarioId; // ID del usuario que creó el ticket, tengo que hacer una conecxion con el cliente
}
