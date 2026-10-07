package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.Streaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Creador {

    private Long id;
    private String nombre;
    private String apellidos;
    private String pais;

}
