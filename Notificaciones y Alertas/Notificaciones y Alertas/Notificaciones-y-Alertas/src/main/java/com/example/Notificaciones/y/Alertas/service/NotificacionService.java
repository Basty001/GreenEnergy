package com.example.Notificaciones.y.Alertas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notificaciones.y.Alertas.model.Notificacion;
import com.example.Notificaciones.y.Alertas.repository.NotificacionRepository;

@Service
public class NotificacionService {

    @Autowired

    private NotificacionRepository notificacionRepository;


    //funcion para buscar todos los pacientes
    public List<Notificacion> listanotificacion(){
        return notificacionRepository.findAll();
    }




    public Notificacion enviarNotificacion(Notificacion notificacion) {
        // Lógica para enviar por Email/SMS (usar JavaMailSender, Twilio, etc.)
        notificacion.setEnviada(true);
        return notificacionRepository.save(notificacion);
    }





}
