package com.example.Gestion.de.Proyecto21.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion.de.Proyecto21.Model.Proyecto;
import com.example.Gestion.de.Proyecto21.Service.ProyectoService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    //Crear un nuevo proyecto
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        Proyecto nuevo = proyectoService.creaProyecto(proyecto);
        return ResponseEntity.ok(nuevo);
    }

    //obtener todos los proyectos
    @GetMapping
    public ResponseEntity<List<Proyecto>> obtenerTodosLosProyectos() {
        return ResponseEntity.ok(proyectoService.obtenerTodosLProyectos());
    }

    //Obtener un proyecto por Id
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        return ResponseEntity.ok(proyecto);
    }
    
    //Atualizar un proyecto por Id
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        Proyecto actualizado = proyectoService.actualizarProyecto(id, proyecto);
        return ResponseEntity.ok(actualizado);
    }

    //Eliminar un proyecto por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.ok("proyecto con ID" + id + "eliminado correctamente.");
    }

}
