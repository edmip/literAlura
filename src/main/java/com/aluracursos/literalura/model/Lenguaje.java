package com.aluracursos.literalura.model;

public enum Lenguaje {

    ESPAÑOL("es"),
    INGLES("en"),
    FRANCES("fr");

    private String lenguaje;

    Lenguaje(String lenguaje){
        this.lenguaje = lenguaje;
    }

    public String getCodigo() {
        return lenguaje;
    }
}
