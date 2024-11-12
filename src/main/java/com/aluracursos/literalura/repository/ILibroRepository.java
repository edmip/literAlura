package com.aluracursos.literalura.repository;


import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ILibroRepository extends JpaRepository<Libro, Long> {

    @Query(value = "SELECT * FROM libros WHERE :idioma = ANY(idioma)", nativeQuery = true)
    List<Libro> BuscarLibroPorIdioma(@Param("idioma") String idioma);

}

