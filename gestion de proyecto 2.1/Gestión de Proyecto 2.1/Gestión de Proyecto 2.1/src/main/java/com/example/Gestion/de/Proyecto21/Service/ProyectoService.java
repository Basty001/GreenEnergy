package com.example.Gestion.de.Proyecto21.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.de.Proyecto21.Model.Proyecto;
import com.example.Gestion.de.Proyecto21.Repository.ProyectoRepository;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    //Crear un nuevo proyecto
    public Proyecto creaProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

    //Obtener todos los proyectos
    public List<Proyecto> obtenerTodosLProyectos(){
        return proyectoRepository.findAll();
    }

    //Buscar un proyecto por Id
    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).get();
    }

    //Actualizar un proyecto
    public Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado) {
        if (proyectoRepository.existsById(id)) {
            proyectoActualizado.setId(id);
            return proyectoRepository.save(proyectoActualizado);
            
        }
        return null;

    }

    //Eliminar un proyecto
    public void eliminarProyecto(Long id){
        if(proyectoRepository.existsById(id)){
            proyectoRepository.deleteById(id);
        }
    }

}
