package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.ReservasHotel;

public record ReservaDTO(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {
}
