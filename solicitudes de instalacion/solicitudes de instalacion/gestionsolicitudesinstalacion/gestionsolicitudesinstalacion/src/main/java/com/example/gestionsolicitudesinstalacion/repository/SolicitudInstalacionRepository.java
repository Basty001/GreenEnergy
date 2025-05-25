package com.example.gestionsolicitudesinstalacion.repository;

import com.example.gestionsolicitudesinstalacion.model.SolicitudInstalacion;
import com.example.gestionsolicitudesinstalacion.model.EstadoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudInstalacionRepository extends JpaRepository<SolicitudInstalacion, Long> {

    List<SolicitudInstalacion> findByIdCliente(Long idCliente);

    List<SolicitudInstalacion> findByEstado(EstadoSolicitud estado);
}