package com.example.gestionsolicitudesinstalacion.controller;

import com.example.gestionsolicitudesinstalacion.model.EstadoSolicitud;
import com.example.gestionsolicitudesinstalacion.model.SolicitudInstalacion;
import com.example.gestionsolicitudesinstalacion.service.SolicitudInstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/solicitudes") 
public class SolicitudInstalacionController {

    private final SolicitudInstalacionService solicitudInstalacionService;

     
    public SolicitudInstalacionController(SolicitudInstalacionService solicitudInstalacionService) {
        this.solicitudInstalacionService = solicitudInstalacionService;
    }

    
    @PostMapping
    public ResponseEntity<SolicitudInstalacion> crearSolicitud(@RequestBody SolicitudInstalacion solicitud) {
        SolicitudInstalacion nuevaSolicitud = solicitudInstalacionService.crearSolicitud(solicitud);
        return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED); 
    }

    
    @GetMapping
    public ResponseEntity<List<SolicitudInstalacion>> obtenerTodasLasSolicitudes() {
        List<SolicitudInstalacion> solicitudes = solicitudInstalacionService.obtenerTodasLasSolicitudes();
        return new ResponseEntity<>(solicitudes, HttpStatus.OK); 
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudInstalacion> obtenerSolicitudPorId(@PathVariable Long id) {
        Optional<SolicitudInstalacion> solicitud = solicitudInstalacionService.obtenerSolicitudPorId(id);
        return solicitud.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));  
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<SolicitudInstalacion> actualizarSolicitud(@PathVariable Long id, @RequestBody SolicitudInstalacion solicitudDetalles) {
        SolicitudInstalacion solicitudActualizada = solicitudInstalacionService.actualizarSolicitud(id, solicitudDetalles);
        if (solicitudActualizada != null) {
            return new ResponseEntity<>(solicitudActualizada, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        solicitudInstalacionService.eliminarSolicitud(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

   
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<SolicitudInstalacion>> obtenerSolicitudesPorIdCliente(@PathVariable Long idCliente) {
        List<SolicitudInstalacion> solicitudes = solicitudInstalacionService.obtenerSolicitudesPorIdCliente(idCliente);
        if (!solicitudes.isEmpty()) {
            return new ResponseEntity<>(solicitudes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<SolicitudInstalacion>> obtenerSolicitudesPorEstado(@PathVariable EstadoSolicitud estado) {
        List<SolicitudInstalacion> solicitudes = solicitudInstalacionService.obtenerSolicitudesPorEstado(estado);
        if (!solicitudes.isEmpty()) {
            return new ResponseEntity<>(solicitudes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
}