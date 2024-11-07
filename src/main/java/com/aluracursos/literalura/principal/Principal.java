package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.mensajes.Mensajes;
import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Datos;
import com.aluracursos.literalura.model.DatosLibro;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.ILibroRepository;
import com.aluracursos.literalura.service.ConsumoApi;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private ConsumoApi consumoApi = new ConsumoApi(); //clase con el metodo que hace la consulta
    private ConvierteDatos convierteDatos = new ConvierteDatos(); //clase con el metodo que transforma la consulta
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    Scanner scanner = new Scanner(System.in);
    private int opcionScogida = -1;
    private ILibroRepository repository;
    private List<Libro> libros;


    public Principal(ILibroRepository repository) {
        this.repository = repository;
    }

    public void muestraElMennu(){

        while (opcionScogida != 0){
            System.out.println(Mensajes.menuPrincipal());
            System.out.println("INGRESE LA OPCION A ELEGIR");
            opcionScogida = scanner.nextInt();
            scanner.nextLine();

            switch (opcionScogida){
                case 1:
                    System.out.println("ingrese nombre de libro");
                    String nombre = scanner.nextLine();

                    var json = consumoApi.obtenerDatos(URL_BASE + nombre.toLowerCase().replace(" ", "%20"));
                    Datos datos = convierteDatos.convertirDatos(json, Datos.class);
                    List<DatosLibro> datosLibro = datos.resultados();

                    Optional<DatosLibro> primeraCoincidencia = datosLibro.stream().findFirst();

                    if (primeraCoincidencia.isPresent()) {
                        DatosLibro datosLibroEncontrado = primeraCoincidencia.get();
                        Libro libro = new Libro(datosLibroEncontrado); // Crea un objeto Libro con los datos del libro encontrado
                        repository.save(libro);
                        System.out.println(libro.toString());

                    } else {
                        System.out.println("No se encontró ningún libro con ese nombre.");
                    }
                    break;

                case 2:

                    mostrarLibrosGuardados();
                    break;

                case 3:


                    listarAutoresRegistrados();

                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }

    }



    public void mostrarLibrosGuardados(){

        System.out.println("Consultando la Base de Datos...");

        libros = repository.findAll();

        libros.forEach(l -> {
            System.out.println(l.toString());
        });

//        libros.forEach(l -> {
//            System.out.println("Título: " + l.getTitulo());
//            System.out.println("Idioma: " + l.getIdioma());
//            System.out.println("Número de descargas: " + l.getNumeroDeDescargas());
//            System.out.println("Autores:");
//            l.getAutor().stream()
//                    .map(autor -> "- " + autor.getNombreAutor() + " (" + autor.getFechaNacimientoAutor() + ")")
//                    .forEach(System.out::println);
//            System.out.println("--------------------");
//       });
    }

    private void listarAutoresRegistrados() {

        libros = repository.findAll();

        libros.forEach(l -> l.getAutor().stream()
                    .map(autor -> "- " + autor.getNombreAutor() + " (" + autor.getFechaNacimientoAutor() + ") (" + autor.getFechaNacimientoAutor() + ")")
                    .forEach(System.out::println));

    }


}
