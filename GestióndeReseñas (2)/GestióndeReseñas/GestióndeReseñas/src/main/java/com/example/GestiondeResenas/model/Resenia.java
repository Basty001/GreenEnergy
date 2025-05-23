package com.example.GestiondeResenas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Resenia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resenia {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Long productoId;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private int calificacion; // 1-5

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private LocalDate fecha;
}
