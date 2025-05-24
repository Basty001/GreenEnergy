package com.example.Soporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Soporte.model.TicketSoporte;

@Repository
public interface TicketSoporteRepository extends JpaRepository<TicketSoporte, Long>{
   
}