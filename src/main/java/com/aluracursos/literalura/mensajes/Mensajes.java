package com.aluracursos.literalura.mensajes;

public class Mensajes {

    public static final String menuPrincipal(){ //MENU PRINCIPAL DE OPCIONES

        return """
                                            1.- Buscar LIbro Por Titulo
                                            2.- Listar Libros registrados
                                            3.- listar Autores Registrados
                                            4.- Listar Autores Vivos en un Determinado Año
                                            5.- Listar Libros Por Idiomas
                                            
                                            0.- salir""";
    }

    public static final String buscarLibroPorIdioma(){ //MENU PRINCIPAL DE OPCIONES

        return """ 
                                            INGRESE EL IDIOMA EN EL CUAL DESEA BUSCAR LOS LIBROS: 
                                            
                                            1.- ESPAÑOL
                                            2.- INGLES
                                            3.- FRANCES
                                            """;
    }

}
