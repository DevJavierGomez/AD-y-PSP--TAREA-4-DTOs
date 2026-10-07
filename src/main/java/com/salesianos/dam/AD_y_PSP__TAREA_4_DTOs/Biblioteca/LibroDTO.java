package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.Biblioteca;

import org.springframework.util.StringUtils;

public record LibroDTO(
        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion
) {

    public static LibroDTO fromEntity(Libro libro) {
        if (libro == null) {
            return null;
        }

        String nombreAutorCompleto = null;

        if (libro.getAutor() != null) {
            Autor a = libro.getAutor();
            String nombreCompleto = "";

            if (StringUtils.hasText(a.getNombre())) {
                nombreCompleto += a.getNombre();
            }

            if (StringUtils.hasText(a.getApellido1())) {
                if (StringUtils.hasText(nombreCompleto)) {
                    nombreCompleto += " ";
                }
                nombreCompleto += a.getApellido1();
            }

            if (StringUtils.hasText(a.getApellido2())) {
                if (StringUtils.hasText(nombreCompleto)) {
                    nombreCompleto += " ";
                }
                nombreCompleto += a.getApellido2();
            }

            if (StringUtils.hasText(nombreCompleto)) {
                nombreAutorCompleto = nombreCompleto;
            }
        }

        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreAutorCompleto,
                libro.getAnioPublicacion()
        );
    }
}
