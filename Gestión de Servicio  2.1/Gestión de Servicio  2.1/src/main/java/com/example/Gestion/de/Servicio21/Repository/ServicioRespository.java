package com.example.Gestion.de.Servicio21.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion.de.Servicio21.Model.Servicio;

@Repository
public interface ServicioRespository extends JpaRepository<Servicio, Long>{

}
