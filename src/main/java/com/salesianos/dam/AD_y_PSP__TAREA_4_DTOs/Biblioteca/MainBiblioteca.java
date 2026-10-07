package com.salesianos.dam.AD_y_PSP__TAREA_4_DTOs.Biblioteca;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainBiblioteca {

    @PostConstruct
    public void Main() {
        Autor autorCompleto = Autor.builder()
                .id(1L)
                .nombre("Miguel")
                .apellido1("de Cervantes")
                .apellido2("Saavedra")
                .nacionalidad("Española")
                .build();

        Autor autorUnApellido = Autor.builder()
                .id(2L)
                .nombre("George")
                .apellido1("Orwell")
                .apellido2(null)
                .nacionalidad("Británica")
                .build();

        Libro libro1 = Libro.builder()
                .id(101L)
                .titulo("Don Quijote de la Mancha")
                .isbn("978-8424116316")
                .anioPublicacion(1605)
                .numeroPaginas(863)
                .autor(autorCompleto)
                .build();

        Libro libro2 = Libro.builder()
                .id(102L)
                .titulo("1984")
                .isbn("978-0451524935")
                .anioPublicacion(1949)
                .numeroPaginas(328)
                .autor(autorUnApellido)
                .build();

        Libro libroSinAutor = Libro.builder()
                .id(103L)
                .titulo("Cantar de mio Cid")
                .isbn("978-8437600604")
                .anioPublicacion(1200)
                .numeroPaginas(200)
                .autor(null)
                .build();

        LibroDTO dto1 = LibroDTO.fromEntity(libro1);
        LibroDTO dto2 = LibroDTO.fromEntity(libro2);
        LibroDTO dto3 = LibroDTO.fromEntity(libroSinAutor);
        LibroDTO dto4 = LibroDTO.fromEntity(null);

        System.out.println("Libro completo: " + dto1);
        System.out.println("Libro sin 2º apellido: " + dto2);
        System.out.println("Libro sin autor: " + dto3);
        System.out.println("Libro nulo: " + dto4);
    }

}
