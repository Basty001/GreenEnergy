package com.gestion.gestionreportes.dto; // Este paquete debe coincidir con la ruta de tus carpetas

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteResumenSolicitudesDTO {

    private String estado;
    private Long cantidad;

}