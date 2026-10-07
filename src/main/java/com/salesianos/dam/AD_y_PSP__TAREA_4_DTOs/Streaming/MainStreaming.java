package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.Streaming;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainStreaming {

    @PostConstruct
    public void Main() {
        Creador creador1 = Creador.builder()
                .id(1L)
                .nombre("Vince")
                .apellidos("Gilligan")
                .pais("EEUU")
                .build();

        Categoria drama = Categoria.builder()
                .id(10L)
                .nombre("Drama")
                .descripcion("Series dramáticas")
                .build();

        Serie s1 = Serie.builder()
                .titulo("Breaking Bad")
                .numeroTemporadas(5)
                .creador(creador1)
                .categoria(drama)
                .imagenes(List.of("http://img1.jpg", "http://img2.jpg"))
                .build();

        Serie s2 = Serie.builder()
                .titulo("Serie Sin Categoria")
                .numeroTemporadas(1)
                .creador(creador1)
                .categoria(null)
                .imagenes(List.of("http://img1.jpg"))
                .build();

        Serie s3 = Serie.builder()
                .titulo("Serie Sin Imagenes")
                .numeroTemporadas(2)
                .imagenes(null)
                .build();

        Serie s4 = Serie.builder()
                .titulo("Serie Con Lista Vacia")
                .numeroTemporadas(3)
                .imagenes(Collections.emptyList())
                .build();

        System.out.println("(Completa): " + SerieDTO.fromEntity(s1));
        System.out.println("(Sin Categoria): " + SerieDTO.fromEntity(s2));
        System.out.println("(Lista Imagenes null): " + SerieDTO.fromEntity(s3));
        System.out.println("(Lista Imagenes vacía): " + SerieDTO.fromEntity(s4));
        System.out.println("(Serie null): " + SerieDTO.fromEntity(null));
    }

}
