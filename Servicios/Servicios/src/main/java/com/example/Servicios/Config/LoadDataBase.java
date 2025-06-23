package com.example.Servicios.Config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Servicios.Model.Servicio;
import com.example.Servicios.Repository.ServicioRepository;

@Configuration
public class LoadDataBase {
     @Bean
    CommandLineRunner initDataBase(ServicioRepository serviRepo) {
        return args -> {
            if (serviRepo.count() == 0) {
                Servicio instalacionPanelSolar = new Servicio();
                instalacionPanelSolar.setNombreServicio("Instalación de Panel Solar");
                instalacionPanelSolar.setDescripcion("Instalación de sistemas fotovoltaicos para energía renovable");
                instalacionPanelSolar.setPrecio(50000);
                instalacionPanelSolar.setIdCategoria((long) 1);
                serviRepo.save(instalacionPanelSolar);

                Servicio mantenimientoPanelSolar = new Servicio();
                mantenimientoPanelSolar.setNombreServicio("Mantenimiento de Panel Solar");
                mantenimientoPanelSolar.setDescripcion("Revisión y mantenimiento de sistemas fotovoltaicos");
                mantenimientoPanelSolar.setPrecio(20000);
                mantenimientoPanelSolar.setIdCategoria((long) 2);
                serviRepo.save(mantenimientoPanelSolar);

                Servicio asesoramientoEnergetico = new Servicio();
                asesoramientoEnergetico.setNombreServicio("Asesoramiento Energético");
                asesoramientoEnergetico.setDescripcion("Consultoría para la optimización del uso de energía");
                asesoramientoEnergetico.setPrecio(15000);
                asesoramientoEnergetico.setIdCategoria((long) 3);
                serviRepo.save(asesoramientoEnergetico);

                System.out.println("Datos iniciales de servicios cargados correctamente");
            } else {
                System.out.println("Datos ya existentes. NO se cargaron datos nuevos");
            }
        };
    }
}
 


