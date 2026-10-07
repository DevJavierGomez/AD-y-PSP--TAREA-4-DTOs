package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.Streaming;

import org.springframework.util.StringUtils;

public record SerieDTO(
        String titulo,
        Integer temporadas,
        String creador,
        String categoria,
        String imagenPrincipal
) {

    public static SerieDTO fromEntity(Serie serie) {
        if (serie == null) {
            return null;
        }

        String creadorTexto = null;
        if (serie.getCreador() != null) {
            Creador c = serie.getCreador();

            if (StringUtils.hasText(c.getNombre()) && StringUtils.hasText(c.getApellidos())) {
                creadorTexto = c.getNombre() + " " + c.getApellidos();
            } else if (StringUtils.hasText(c.getNombre())) {
                creadorTexto = c.getNombre();
            } else if (StringUtils.hasText(c.getApellidos())) {
                creadorTexto = c.getApellidos();
            }
        }

        String categoriaTexto = null;
        if (serie.getCategoria() != null && StringUtils.hasText(serie.getCategoria().getNombre())) {
            categoriaTexto = serie.getCategoria().getNombre();
        }

        String imagenTexto = null;
        if (serie.getImagenes() != null && !serie.getImagenes().isEmpty()) {
            String primeraImagen = serie.getImagenes().get(0);
            if (StringUtils.hasText(primeraImagen)) {
                imagenTexto = primeraImagen;
            }
        }

        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                creadorTexto,
                categoriaTexto,
                imagenTexto
        );
    }
}
