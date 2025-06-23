package com.example.Servicios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Servicios.Model.Servicio;
import com.example.Servicios.Repository.ServicioRepository;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarTodos(){
        return servicioRepository.findAll();
    }

    public Servicio guardar(Servicio servicio){
        return servicioRepository.save(servicio);
    }

    public Servicio buscarPorId(Long id){
        return servicioRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        servicioRepository.deleteById(id);
    }

}
