package com.example.soporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.soporte.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    List<Ticket> findByIdUsuario(Long idUsuario); // Busca tickets por ID de usuario    
}
