package com.example.gestionprivilegios.repository; 

import com.example.gestionprivilegios.model.Permiso; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository 
public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    

    
    Permiso findByName(String name);
}