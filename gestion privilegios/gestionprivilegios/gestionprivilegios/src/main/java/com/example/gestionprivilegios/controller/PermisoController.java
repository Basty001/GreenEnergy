package com.example.gestionprivilegios.controller; 

import com.example.gestionprivilegios.model.Permiso;
import com.example.gestionprivilegios.service.PermisoService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 

import java.util.List; 

@RestController 
@RequestMapping("/api/permisos") 
public class PermisoController {

    @Autowired 
    private PermisoService permisoService;



    @GetMapping
    public ResponseEntity<List<Permiso>> getAllPermisos() {
        List<Permiso> permisos = permisoService.getAllPermisos(); 
        return new ResponseEntity<>(permisos, HttpStatus.OK); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permiso> getPermisoById(@PathVariable Long id) {
        return permisoService.getPermisoById(id)
                .map(permiso -> new ResponseEntity<>(permiso, HttpStatus.OK)) 
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    }

   
    @PostMapping
    public ResponseEntity<Permiso> createPermiso(@RequestBody Permiso permiso) {
        Permiso createdPermiso = permisoService.createPermiso(permiso); 
        return new ResponseEntity<>(createdPermiso, HttpStatus.CREATED); 
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Permiso> updatePermiso(@PathVariable Long id, @RequestBody Permiso permiso) {
        try {
            Permiso updatedPermiso = permisoService.updatePermiso(id, permiso); 
            return new ResponseEntity<>(updatedPermiso, HttpStatus.OK); 
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermiso(@PathVariable Long id) {
        permisoService.deletePermiso(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}