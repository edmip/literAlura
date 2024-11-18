
package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.mensajes.Mensajes;
import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.IAutorRepository;
import com.aluracursos.literalura.repository.ILibroRepository;
import com.aluracursos.literalura.service.ConsumoApi;
import com.aluracursos.literalura.service.ConvierteDatos;
import jakarta.transaction.Transactional;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    // Códigos de escape ANSI para el color rojo
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_RESET = "\u001B[0m";

    // Códigos de escape ANSI para el color verde
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREEN_RESET = "\u001B[0m";

    private ConsumoApi consumoApi = new ConsumoApi(); //clase con el metodo que hace la consulta
    private ConvierteDatos convierteDatos = new ConvierteDatos(); //clase con el metodo que transforma la consulta
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    Scanner scanner = new Scanner(System.in);
    private int opcionScogida = -1;
    private ILibroRepository repository;
    private IAutorRepository repository2;
    private List<Libro> libros;
    private Autor autor;
    private String libroAutor;


    public Principal(ILibroRepository repository, IAutorRepository repository2) {
        this.repository = repository;
        this.repository2 = repository2;
    }


    public void muestraElMennu(){

        System.out.println(Mensajes.saludoPrincipal());

        while (opcionScogida != 0){
            System.out.println(Mensajes.menuPrincipal());
            try {
                opcionScogida = scanner.nextInt();
                scanner.nextLine();


                switch (opcionScogida) {
                    case 1:

                        System.out.println("\ningrese nombre de libro");
                        String nombre = scanner.nextLine();
                        Thread hiloCargando = new Thread(() -> Mensajes.cargando("\nBUSCANDO..."));
                        hiloCargando.start();

                        var json = consumoApi.obtenerDatos(URL_BASE + nombre.toLowerCase().replace(" ", "%20"));
                        Datos datos = convierteDatos.convertirDatos(json, Datos.class);
                        List<DatosLibro> datosLibro = datos.resultados();

                        Optional<DatosLibro> primeraCoincidencia = datosLibro.stream().findFirst();

                        if (primeraCoincidencia.isPresent()) {

                            DatosLibro datosLibroEncontrado = primeraCoincidencia.get();

                            Optional<Libro> libroEnBase = repository.findByTitulo(datosLibroEncontrado.titulo());

                            if (libroEnBase.isPresent()){

                                System.out.println(ANSI_GREEN + "\nEL LIBRO YA ESTA GUARDADO EN LA BASE DE DATOS" + ANSI_GREEN_RESET);
                                libroEnBase.toString();

                            }else {
                                System.out.println(ANSI_GREEN + "\nlibro encontrado" + ANSI_GREEN_RESET);
                                Libro libro = new Libro(datosLibroEncontrado); // Crea un objeto Libro con los datos del libro encontrado
                                autor = libro.getAutor().get(0);

                                libroAutor = libro.getTitulo();

                                autor.setTituliLibro(libroAutor);
                                repository.save(libro);
                                System.out.println(libro.toString());

                            }

                        } else {
                            System.out.println(ANSI_RED + "No se encontró ningún libro con ese nombre." + ANSI_RED_RESET);
                        }
                        break;

                    case 2:

                        mostrarLibrosGuardados();
                        break;

                    case 3:

                        listarAutoresRegistrados();
                        break;

                    case 4:

                        autoresVivos();
                        break;

                    case 5:

                        librosPorIdiomas();
                        break;

                    case 0:

                        System.out.println(ANSI_RED + "HA SALIDO DEL SISTEMA..." + ANSI_RED_RESET);
                        break;

                    default:

                        System.out.println(ANSI_RED + "OPCION INVÁLIDA..." + ANSI_RED_RESET);

                }
            }catch (InputMismatchException e){
                System.out.println(ANSI_RED + "OPCION INVÁLIDA..." + ANSI_RED_RESET);
                scanner.nextLine();
            }
        }

    }



    public void mostrarLibrosGuardados(){

        System.out.println("Consultando la Base de Datos...");

        libros = repository.findAll();

        libros.forEach(l -> {
            System.out.println(l.toString());
        });

    }


    @Transactional
    private void listarAutoresRegistrados() {

        List<String> autores = repository2.MostrarAutores();
        autores.forEach(a -> {
            String[] datos = a.split(",(?=\\w)"); // Divide por coma solo si hay un carácter alfanumérico después
            System.out.println(String.format("Autor: %s\nFecha de Nacimiento: %s\nFecha de Fallecimiento: %s\nLibros: %s\n", datos[0], datos[1], datos[2], datos[3]));

        });
    }


    private void autoresVivos() {

        System.out.println("INGRESE LA FECHA QUE DESEA CONSULTAR");
        int fecha = scanner.nextInt();
        scanner.nextLine();

        List<String> autoresVivos = repository2.autoresVivos(fecha);
        autoresVivos.forEach(a -> {
            String[] datos = a.split(",(?=\\w)"); // Divide por coma solo si hay un carácter alfanumérico después
            System.out.println(String.format("\nAutor: %s\nFecha de Nacimiento: %s\nFecha de Fallecimiento: %s\nLibros: %s\n", datos[0], datos[1], datos[2], datos[3]));

        });
    }

    private void librosPorIdiomas() {

        // Mostrar las opciones de idioma al usuario
        for (int i = 0; i < Lenguaje.values().length; i++) {
            System.out.println((i + 1) + ". " + Lenguaje.values()[i].getCodigo());
        }

        // Leer la opción del usuario
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Validar la opción
        if (opcion >= 1 && opcion <= Lenguaje.values().length) {
            // Obtener el idioma seleccionado del enum
            Lenguaje idiomaEscogico = Lenguaje.values()[opcion - 1];

            // Buscar libros por idioma
            libros = repository.BuscarLibroPorIdioma(idiomaEscogico.getCodigo());

            // Mostrar los resultados
            libros.forEach(l -> {
                System.out.println(l.toString());
            });
        } else {
            System.out.println(ANSI_RED + "Opción inválida. Por favor, selecciona un idioma válido." + ANSI_RED_RESET);
        }
    }
}
