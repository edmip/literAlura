package com.aluracursos.literalura.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("name")
    private String nombreAutor;

    @JsonProperty("birth_year")
    private String fechaNacimientoAutor;

    @JsonProperty("death_year")
    private String fechaFallecimientoAutor;

    @ManyToMany
    @JoinTable( //Esto es necesario cuando la realacion es muchos a muchos
            name = "autores_libro", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "autor_id"), // Columna de unión para Autor
            inverseJoinColumns = @JoinColumn(name = "libro_id") // Columna de unión para Libro
    )
    private List<Libro> libro;



    public Autor() {
    }



    public Autor(DatosAutor datosAutor) {

        this.nombreAutor = datosAutor.nombreAutor();
        this.fechaNacimientoAutor = datosAutor.fechaNacimientoAutor();
        this.fechaFallecimientoAutor = datosAutor.fechaFallecimientoAutor();

    }
    public Autor(String nombreAutor, String fechaNacimientoAutor, String fechaFallecimientoAutor) {
        this.nombreAutor = nombreAutor;
        this.fechaNacimientoAutor = fechaNacimientoAutor;
        this.fechaFallecimientoAutor = fechaFallecimientoAutor;
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

    public String getFechaNacimientoAutor() {
        return fechaNacimientoAutor;
    }

    public void setFechaNacimientoAutor(String fechaNacimientoAutor) {
        this.fechaNacimientoAutor = fechaNacimientoAutor;
    }

    public String getFechaFallecimientoAutor() {
        return fechaFallecimientoAutor;
    }

    public void setFechaFallecimientoAutor(String fechaFallecimientoAutor) {
        this.fechaFallecimientoAutor = fechaFallecimientoAutor;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaNacimientoAutor='" + fechaNacimientoAutor + '\'' +
                ", fechaFallecimientoAutor='" + fechaFallecimientoAutor + '\'' +
                ", libro=" + libro +
                '}';
    }
}
