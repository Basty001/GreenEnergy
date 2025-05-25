package com.example.gestionsolicitudesinstalacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "solicitudes_instalacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudInstalacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private String tipoInmueble;

    @Column(nullable = false)
    private String direccionInstalacion;

    @Column(nullable = false)
    private Double consumoMensualKwh;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSolicitud estado;

    private LocalDate fechaSolicitud;
    private LocalDate fechaEstimadaInstalacion;
    private Long idTecnicoAsignado;
    private String observaciones;

}