package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.ReservasHotel;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainReservaHotel {

    @PostConstruct
    public void Main() {
        Cliente cliente1 = Cliente.builder()
                .id(1L)
                .nombre("Laura")
                .apellidos("Gómez Pérez")
                .email("laura@email.com")
                .build();

        Habitacion hab1 = Habitacion.builder()
                .id(10L)
                .numero("204")
                .tipo("Doble")
                .precioNoche(85.50)
                .planta(2)
                .build();

        Reserva resCompleta = Reserva.builder()
                .id(100L)
                .codigo("RES-001")
                .numeroNoches(3)
                .cliente(cliente1)
                .habitacion(hab1)
                .build();

        Habitacion habSinPrecio = Habitacion.builder()
                .numero("101")
                .tipo("Individual")
                .build();

        Reserva resIncompleta = Reserva.builder()
                .codigo("RES-002")
                .numeroNoches(2)
                .habitacion(habSinPrecio)
                .build();

        ReservaDTO dto1 = ReservaDTO.fromEntity(resCompleta);
        ReservaDTO dto2 = ReservaDTO.fromEntity(resIncompleta);
        ReservaDTO dto3 = ReservaDTO.fromEntity(null);

        System.out.println("Reserva Completa: " + dto1);
        System.out.println("Reserva Incompleta: " + dto2);
        System.out.println("Reserva Nula: " + dto3);
    }

}
