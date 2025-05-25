package com.example.Notificaciones1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Notificaciones1.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long>{
    List<Notificacion> findByUsuarioId(Long usuarioId);
    List<Notificacion> findByUsuarioIdAndLeidaFalse(Long usuarioId);

}
