package com.example.Notificaciones1.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notificaciones1.model.Notificacion;
import com.example.Notificaciones1.repository.NotificacionRepository;
import com.example.Notificaciones1.webclient.ClienteClient;

@Service
public class NotificacionService {
    
    @Autowired
    private NotificacionRepository notificacionRepository;
    
    @Autowired
    private ClienteClient clienteClient; // Inyectamos el ClienteClient correctamente

  
    public List<Notificacion> getAllNotificaciones() {
        return notificacionRepository.findAll();
    }


    public Notificacion saveNotificacion(Notificacion notificacion) {
        // ver que el cliente existe
        Map<String, Object> cliente = clienteClient.getClienteById(notificacion.getUsuarioId());
        if (cliente == null || cliente.isEmpty()) {
            throw new RuntimeException("Cliente con ID " + notificacion.getUsuarioId() + " no encontrado");
        }
        
        // ver que el mensaje no esté vacío
        if (notificacion.getMensaje() == null || notificacion.getMensaje().trim().isEmpty()) {
            throw new RuntimeException("El mensaje de la notificación es obligatorio");
        }
        
        //  poner los valores por defecto
        notificacion.setFechaCreacion(LocalDateTime.now());
        notificacion.setLeida(false);
        
        //  Guardar en la base de datos
        return notificacionRepository.save(notificacion);
    }



    public List<Notificacion> getNotificacionesByUsuarioId(Long usuarioId) {
        // Verificar que el usuario existe primero
        Map<String, Object> cliente = clienteClient.getClienteById(usuarioId);
        if (cliente == null || cliente.isEmpty()) {
            throw new RuntimeException("Cliente con ID " + usuarioId + " no encontrado");
        }
        
        return notificacionRepository.findByUsuarioId(usuarioId);
    }


    public List<Notificacion> getNotificacionesNoLeidasByUsuarioId(Long usuarioId) {
        // Verificar que el usuario existe primero
        Map<String, Object> cliente = clienteClient.getClienteById(usuarioId);
        if (cliente == null || cliente.isEmpty()) {
            throw new RuntimeException("Cliente con ID " + usuarioId + " no encontrado");
        }
        
        return notificacionRepository.findByUsuarioIdAndLeidaFalse(usuarioId);
    }


    public Notificacion marcarComoLeida(Long id) {
        Notificacion notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación con ID " + id + " no encontrada"));
        
        notificacion.setLeida(true);
        return notificacionRepository.save(notificacion);
    }
}