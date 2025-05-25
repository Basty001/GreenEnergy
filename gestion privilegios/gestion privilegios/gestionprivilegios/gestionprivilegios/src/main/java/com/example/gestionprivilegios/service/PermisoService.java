package com.example.gestionprivilegios.service; 

import com.example.gestionprivilegios.model.Permiso; 
import com.example.gestionprivilegios.repository.PermisoRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import java.util.List; 
import java.util.Optional; 

@Service 
public class PermisoService {

    @Autowired 
    private PermisoRepository permisoRepository;

    
    public List<Permiso> getAllPermisos() {
        return permisoRepository.findAll(); 
    }

    
    public Optional<Permiso> getPermisoById(Long id) {
        return permisoRepository.findById(id); 
    }

    
    public Permiso createPermiso(Permiso permiso) {
        return permisoRepository.save(permiso); 
    }

    
    public Permiso updatePermiso(Long id, Permiso updatedPermiso) {
        
        return permisoRepository.findById(id).map(permiso -> {
            permiso.setName(updatedPermiso.getName());
            permiso.setDescription(updatedPermiso.getDescription());
            return permisoRepository.save(permiso); 
        }).orElseThrow(() -> new RuntimeException("Permiso not found with id " + id)); 
    }

    
    public void deletePermiso(Long id) {
        permisoRepository.deleteById(id); 
    }
}