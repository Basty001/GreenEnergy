package com.example.GestiondeResenas.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestiondeResenas.model.Resenia;
import com.example.GestiondeResenas.repository.ReseniaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReseniaService {
    @Autowired
    private ReseniaRepository reseniaRepository;

    public Resenia crearResenia(Resenia resenia) {
        resenia.setFecha(LocalDate.now());
        return reseniaRepository.save(resenia);
    }


    /*unir com el microservicio de producto */

    /*public List<Resenia> obtenerReseniasPorProducto(Long productoId) {
        return reseniaRepository.findByProductoId(productoId);
    } */
}
