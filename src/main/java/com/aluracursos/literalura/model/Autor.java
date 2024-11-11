package com.aluracursos.literalura.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("name")
//@Column(unique = true)
    private String nombreAutor;

    @JsonProperty("birth_year")
    private int fechaNacimientoAutor;

    @JsonProperty("death_year")
    private int fechaFallecimientoAutor;

    @ManyToMany
    @JoinTable( //Esto es necesario cuando la realacion es muchos a muchos
            name = "autores_libro", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "autor_id"), // Columna de unión para Autor
            inverseJoinColumns = @JoinColumn(name = "libro_id") // Columna de unión para Libro
    )
    @Fetch(FetchMode.JOIN)
    private List<Libro> libro;

    @Column(name = "libros")
    private String tituliLibro;


    public Autor() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getFechaNacimientoAutor() {
        return fechaNacimientoAutor;
    }

    public void setFechaNacimientoAutor(int fechaNacimientoAutor) {
        this.fechaNacimientoAutor = fechaNacimientoAutor;
    }

    public int getFechaFallecimientoAutor() {
        return fechaFallecimientoAutor;
    }

    public void setFechaFallecimientoAutor(int fechaFallecimientoAutor) {
        this.fechaFallecimientoAutor = fechaFallecimientoAutor;
    }

    public String getTituliLibro() {
        return tituliLibro;
    }

    public void setTituliLibro(String tituliLibro) {
        this.tituliLibro = tituliLibro;
    }

//    public String getLibro(List<Libro> libro) {
//
//        return libro.stream()
//                .map(l -> l.getTitulo())
//                .collect(Collectors.joining(", "));
//    }
//
//    public void setLibro(List<Libro> libro) {
//        this.libro = libro; // Asigna la lista de libros recibida
//        for (Libro l : this.libro) {
//            l.setTitulo(l.getTitulo());
//        }
//    }

    @Override
    public String toString() {
        return "Autor{" +

                ", nombreAutor='" + getNombreAutor() + '\'' +
                ", fechaNacimientoAutor='" + getFechaNacimientoAutor() + '\'' +
                ", fechaFallecimientoAutor='" + getFechaFallecimientoAutor() + '\'' +
                ", libro=" + getTituliLibro() +
                '}';
    }
}