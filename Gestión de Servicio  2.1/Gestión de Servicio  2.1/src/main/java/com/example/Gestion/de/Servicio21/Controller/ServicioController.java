package com.example.Gestion.de.Servicio21.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion.de.Servicio21.Model.Servicio;
import com.example.Gestion.de.Servicio21.Service.ServicioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/Servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio>listar() {
        return servicioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Servicio buscarPorId(@PathVariable Long id) {
        return servicioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        servicioService.eliminar(id);
    }
    
    

}
