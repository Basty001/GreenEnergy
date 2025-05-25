package com.example.Notificaciones1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notificaciones1.model.Notificacion;
import com.example.Notificaciones1.service.NotificacionService;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    
    @Autowired
    private NotificacionService notificacionService;

    /**
    Obtiene todas las notificaciones
     GET /api/notificaciones
     */
    @GetMapping
    public ResponseEntity<List<Notificacion>> getAllNotificaciones() {
        return ResponseEntity.ok(notificacionService.getAllNotificaciones());
    }

    /**
     Crea una nueva notificación
     POST /api/notificaciones
     */
    @PostMapping
    public ResponseEntity<Notificacion> saveNotificacion(@RequestBody Notificacion notificacion) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(notificacionService.saveNotificacion(notificacion));
    }

    /**
     ver notificaciones por usuario
     GET /api/notificaciones/usuario/{usuarioId}
     */
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Notificacion>> getNotificacionesByUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(notificacionService.getNotificacionesByUsuarioId(usuarioId));
    }

    /**
     ver notificaciones no leídas por usuario
     GET /api/notificaciones/usuario/{usuarioId}/no-leidas
     */
    @GetMapping("/usuario/{usuarioId}/no-leidas")
    public ResponseEntity<List<Notificacion>> getNotificacionesNoLeidasByUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(notificacionService.getNotificacionesNoLeidasByUsuarioId(usuarioId));
    }

    /**
     Marca notificación como leída
      PUT /api/notificaciones/{id}/marcar-leida
     */
    @PutMapping("/{id}/marcar-leida")
    public ResponseEntity<Notificacion> marcarNotificacionComoLeida(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.marcarComoLeida(id));
    }
}

