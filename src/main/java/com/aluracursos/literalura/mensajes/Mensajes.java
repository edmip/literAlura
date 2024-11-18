package com.aluracursos.literalura.mensajes;

public class Mensajes {

    // Códigos de escape ANSI para el color verde
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREEN_RESET = "\u001B[0m";

    public static final String saludoPrincipal() {
        return ANSI_GREEN + "╔════════════════════════════════════════════╗\n"
                + "║                 Liter_Alura" + ANSI_GREEN_RESET + ANSI_GREEN+"                ║\n"
                + "║ "   + "           Tu Biblioteca Virtual" + ANSI_GREEN_RESET + ANSI_GREEN + "           ║\n"
                + "╚════════════════════════════════════════════╝" + ANSI_GREEN_RESET;
    }

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
