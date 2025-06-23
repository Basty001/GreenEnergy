package com.example.Servicios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Servicios.Model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

}
