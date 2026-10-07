package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.ReservasHotel;

import org.springframework.util.StringUtils;

public record ReservaDTO(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {

    public static ReservaDTO fromEntity(Reserva reserva) {
        if (reserva == null) {
            return null;
        }

        String clienteTexto = null;
        if (reserva.getCliente() != null) {
            Cliente c = reserva.getCliente();

            if (StringUtils.hasText(c.getNombre()) && StringUtils.hasText(c.getApellidos())) {
                clienteTexto = c.getNombre() + " " + c.getApellidos();
            } else if (StringUtils.hasText(c.getNombre())) {
                clienteTexto = c.getNombre();
            } else if (StringUtils.hasText(c.getApellidos())) {
                clienteTexto = c.getApellidos();
            }
        }

        String habitacionTexto = null;
        if (reserva.getHabitacion() != null) {
            Habitacion h = reserva.getHabitacion();

            if (StringUtils.hasText(h.getNumero()) && StringUtils.hasText(h.getTipo())) {
                habitacionTexto = h.getNumero() + " - " + h.getTipo();
            } else if (StringUtils.hasText(h.getNumero())) {
                habitacionTexto = h.getNumero();
            } else if (StringUtils.hasText(h.getTipo())) {
                habitacionTexto = h.getTipo();
            }
        }

        Double precioTotalCalculado = null;
        if (reserva.getNumeroNoches() != null
                && reserva.getHabitacion() != null
                && reserva.getHabitacion().getPrecioNoche() != null) {

            precioTotalCalculado = reserva.getNumeroNoches() * reserva.getHabitacion().getPrecioNoche();
        }

        return new ReservaDTO(
                reserva.getCodigo(),
                clienteTexto,
                habitacionTexto,
                reserva.getNumeroNoches(),
                precioTotalCalculado
        );
    }
}
