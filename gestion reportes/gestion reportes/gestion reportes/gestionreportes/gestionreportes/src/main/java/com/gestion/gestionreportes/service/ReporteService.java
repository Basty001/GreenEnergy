package com.gestion.gestionreportes.service;

import com.gestion.gestionreportes.dto.ReporteResumenSolicitudesDTO;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ReporteService {

    public List<ReporteResumenSolicitudesDTO> generarReporteResumenSolicitudes() {
        return Arrays.asList(
            new ReporteResumenSolicitudesDTO("PENDIENTE", 5L),
            new ReporteResumenSolicitudesDTO("EN_PROCESO", 12L),
            new ReporteResumenSolicitudesDTO("COMPLETADO", 8L),
            new ReporteResumenSolicitudesDTO("CANCELADO", 2L)
        );
    }
}