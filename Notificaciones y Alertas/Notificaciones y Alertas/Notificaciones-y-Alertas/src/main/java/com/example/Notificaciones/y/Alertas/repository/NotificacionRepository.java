package com.example.Notificaciones.y.Alertas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Notificaciones.y.Alertas.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
