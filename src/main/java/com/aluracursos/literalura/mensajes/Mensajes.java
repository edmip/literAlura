package com.aluracursos.literalura.mensajes;

public class Mensajes {

    public static final String menuPrincipal() { //MENU PRINCIPAL DE OPCIONES

        return """
                \n
                1.- Buscar LIbro Por Titulo
                2.- Listar Libros registrados
                3.- listar Autores Registrados
                4.- Listar Autores Vivos en un Determinado Año
                5.- Listar Libros Por Idiomas
                
                0.- salir
                
                INGRESE EL NUMERO DE LA OPCION A ELEGIR""";
    }



    public static void cargando(String palabra) {
        for (char letra : palabra.toCharArray()) {
            System.out.print(letra);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
