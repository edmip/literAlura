package com.aluracursos.literalura.model;

public enum Lenguaje {
    ESPAÑOL("es", "Español"),
    INGLES("en", "Inglés"),
    FRANCES("fr", "Francés");

    private String lenguaje;
    private String nombre;

    Lenguaje(String lenguaje, String nombre) {
        this.lenguaje = lenguaje;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return lenguaje;
    }

    public String getNombre() {
        return nombre;
    }
}
