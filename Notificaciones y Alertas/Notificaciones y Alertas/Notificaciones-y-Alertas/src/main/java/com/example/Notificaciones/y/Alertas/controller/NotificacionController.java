package com.example.Notificaciones.y.Alertas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notificaciones.y.Alertas.model.Notificacion;
import com.example.Notificaciones.y.Alertas.service.NotificacionService;



@RestController
@RequestMapping("/api/v1/notificacion")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;


    @GetMapping
    public ResponseEntity<List<Notificacion>> listarnotificacion(){
        //variable para almacenar el resultado del select
        List<Notificacion> notificacion = notificacionService.listanotificacion();
        //preguntar si vienen registros o no
        if(notificacion.isEmpty()){
            //si esta vacia retorno codigo 204
            return ResponseEntity.noContent().build();
        }
        //si no esta vacia retorno codigo 200 cn la lista
        return ResponseEntity.ok(notificacion);
    }

    @PostMapping
    public Notificacion enviarNotificacion(@RequestBody Notificacion notificacion) {
        return notificacionService.enviarNotificacion(notificacion);
    }
}
