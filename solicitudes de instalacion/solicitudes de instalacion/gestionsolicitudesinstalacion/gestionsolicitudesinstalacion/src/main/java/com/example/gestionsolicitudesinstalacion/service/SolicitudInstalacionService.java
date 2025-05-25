package com.example.gestionsolicitudesinstalacion.service;

import com.example.gestionsolicitudesinstalacion.model.SolicitudInstalacion;
import com.example.gestionsolicitudesinstalacion.model.EstadoSolicitud;
import com.example.gestionsolicitudesinstalacion.repository.SolicitudInstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudInstalacionService {

    private final SolicitudInstalacionRepository solicitudInstalacionRepository;

    @Autowired
    public SolicitudInstalacionService(SolicitudInstalacionRepository solicitudInstalacionRepository) {
        this.solicitudInstalacionRepository = solicitudInstalacionRepository;
    }

    public SolicitudInstalacion crearSolicitud(SolicitudInstalacion solicitud) {
        solicitud.setFechaSolicitud(LocalDate.now());
        return solicitudInstalacionRepository.save(solicitud);
    }

    public List<SolicitudInstalacion> obtenerTodasLasSolicitudes() {
        return solicitudInstalacionRepository.findAll();
    }

    public Optional<SolicitudInstalacion> obtenerSolicitudPorId(Long id) {
        return solicitudInstalacionRepository.findById(id);
    }

    public SolicitudInstalacion actualizarSolicitud(Long id, SolicitudInstalacion solicitudDetalles) {
        return solicitudInstalacionRepository.findById(id)
                .map(solicitudExistente -> {
                    solicitudExistente.setIdCliente(solicitudDetalles.getIdCliente());
                    solicitudExistente.setTipoInmueble(solicitudDetalles.getTipoInmueble());
                    solicitudExistente.setDireccionInstalacion(solicitudDetalles.getDireccionInstalacion());
                    solicitudExistente.setConsumoMensualKwh(solicitudDetalles.getConsumoMensualKwh());
                    solicitudExistente.setEstado(solicitudDetalles.getEstado());
                    solicitudExistente.setFechaEstimadaInstalacion(solicitudDetalles.getFechaEstimadaInstalacion());
                    solicitudExistente.setIdTecnicoAsignado(solicitudDetalles.getIdTecnicoAsignado());
                    solicitudExistente.setObservaciones(solicitudDetalles.getObservaciones());
                    return solicitudInstalacionRepository.save(solicitudExistente);
                }).orElse(null);
    }

    public void eliminarSolicitud(Long id) {
        solicitudInstalacionRepository.deleteById(id);
    }

    public List<SolicitudInstalacion> obtenerSolicitudesPorIdCliente(Long idCliente) {
        return solicitudInstalacionRepository.findByIdCliente(idCliente);
    }

    public List<SolicitudInstalacion> obtenerSolicitudesPorEstado(EstadoSolicitud estado) {
        return solicitudInstalacionRepository.findByEstado(estado);
    }
}