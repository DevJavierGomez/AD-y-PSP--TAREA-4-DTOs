package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.ReservasHotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    private Long id;
    private String codigo;
    private Integer numeroNoches;
    private Cliente cliente;
    private Habitacion habitacion;

}
