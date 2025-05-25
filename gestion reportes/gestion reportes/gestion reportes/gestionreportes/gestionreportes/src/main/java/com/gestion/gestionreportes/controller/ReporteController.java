package com.gestion.gestionreportes.controller;

import com.gestion.gestionreportes.dto.ReporteResumenSolicitudesDTO;
import com.gestion.gestionreportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/resumen-solicitudes")
    public ResponseEntity<List<ReporteResumenSolicitudesDTO>> getResumenSolicitudes() {
        List<ReporteResumenSolicitudesDTO> resumen = reporteService.generarReporteResumenSolicitudes();
        return ResponseEntity.ok(resumen);
    }
}