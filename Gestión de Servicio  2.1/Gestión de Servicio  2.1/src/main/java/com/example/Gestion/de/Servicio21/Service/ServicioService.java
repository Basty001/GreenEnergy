package com.example.Gestion.de.Servicio21.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.de.Servicio21.Model.Servicio;
import com.example.Gestion.de.Servicio21.Repository.ServicioRespository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRespository servicioRespository;

    public List<Servicio> listarTodos() {
        return servicioRespository.findAll();
    }

    public Servicio guardar(Servicio servicio){
        return servicioRespository.save(servicio);
    }

    public Servicio buscarPorId(Long id) {
        return servicioRespository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        servicioRespository.deleteById(id);
    }

}
