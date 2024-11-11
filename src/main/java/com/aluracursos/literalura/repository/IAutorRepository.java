package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface IAutorRepository extends JpaRepository<Autor, Long> {

    /////////////////CONSULTA PARA MOSTRAR AUTORES/////////////
   @Query(value = "SELECT nombre_autor, fecha_nacimiento_autor, fecha_fallecimiento_autor, STRING_AGG(libros, ', ') AS libros_agrupados FROM autores GROUP BY nombre_autor, fecha_nacimiento_autor, fecha_fallecimiento_autor", nativeQuery = true)
    List<String> MostrarAutores();

    /////////////////CONSULTA PARA MOSTRAR AUTORES VIVOS/////////////
    @Query(value = "SELECT nombre_autor, fecha_nacimiento_autor, fecha_fallecimiento_autor, STRING_AGG(libros, ', ') AS libros_agrupados FROM autores WHERE nombre_autor IN (SELECT nombre_autor FROM autores WHERE autores.fecha_nacimiento_autor <= :fecha AND fecha_fallecimiento_autor > :fecha) GROUP BY nombre_autor, fecha_nacimiento_autor, fecha_fallecimiento_autor;", nativeQuery = true)
    List<String> autoresVivos (@Param("fecha") Integer fecha);
}
