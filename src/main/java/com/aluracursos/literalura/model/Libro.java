
package com.aluracursos.literalura.model;


import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;


@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;

    private List<String> idioma;

    private Double numeroDeDescargas;

    public Libro() {
    }

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.autor = datosLibro.autor();
        this.idioma = datosLibro.idioma();
        this.numeroDeDescargas = Optional.ofNullable(datosLibro.numeroDeDescargas()).orElse(0.0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        //autor.forEach(e -> e.setLibro((List<Libro>) this));
        this.autor = autor;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }


    @Override
    public String toString() {
        return "\n-----------Libro-----------" +
                "\n titulo='" + titulo + '\'' +
                "\n autor=" + getAutor().get(0).getNombreAutor() +
                "\n idioma=" + idioma +
                "\n numeroDeDescargas=" + numeroDeDescargas +
                "\n---------------------------";
    }
}
