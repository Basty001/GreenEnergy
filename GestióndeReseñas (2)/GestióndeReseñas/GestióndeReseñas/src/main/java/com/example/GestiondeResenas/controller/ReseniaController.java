package com.example.GestiondeResenas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestiondeResenas.model.Resenia;
import com.example.GestiondeResenas.service.ReseniaService;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {
    @Autowired
    private ReseniaService reseniaService;

    @PostMapping
    public Resenia crearResenia(@RequestBody Resenia resenia) {
        return reseniaService.crearResenia(resenia);
    }

}
