![Beige Library Lovers Day Illustration Poster](https://github.com/user-attachments/assets/53131642-c9c8-4d79-84e0-0e49a12e93b0)

**LiterAlura** es una aplicación en Java, con interaccion en consola para consultar y gestionar un catálogo de autores y libros. Esta aplicación permite realizar **Consultas** de una API para liuego ser guardadas en  una base de datos con autores y libros. Su objetivo es brindar una experiencia enriquecedora en la administración y consulta de contenido literario.

La aplicación utiliza la API de [Gutendex](https://gutendex.com/ "API para libros de dominio público") 📜, para obtener datos de libros de dominio público, maneja respuestas en formato JSON, y permite persistir estos datos en una base de datos PostgreSQL, desde la que luego podemos realizar diversas consultas para mostrar todo lo relacionado con Libros y Autores.

Los resultados se filtran y muestran en la consola de manera interactiva.


## 📑Tabla de Contenidos
- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Instalación y Configuración](#instalación-y-configuración)
- [Guía de Uso](#guía-de-uso)
    - [Menú Principal](#menú-principal)
    - [Funcionalidades](#funcionalidades)


## ✨Características

- 🔍**Búsqueda y Registro de Libros por Título**: Consulta a la API de [Gutendex](https://gutendex.com/ "API para libros de dominio público") para buscar libros por título. Al encontrar un libro, lo registra y almacena en la base de datos, evitando duplicados al verificar previamente su existencia. Si el libro ya está registrado, muestra un mensaje indicando que ya esta en la base de datos.
- 📚**Listado de libros guardados en la base de datos**: Busca libros usando consultas directas en la base de datos. Filtra libros por idioma en la base de datos. Los idiomas deben ingresarse en formato ISO 639-1 (ej., es para español).
- ✒️**Lista de autores de la base de datos**: Encuentra autores y sus libros asociados en la base de datos rápidamente mediante consultas SQL.
- 📝**Listado de autoreres vivos por un año dado por el usuario**: Muestra autores vivos en un año determinado y permite filtrar autores por rango fecha de nacimiento.
- ✅**Validación de Datos de Entrada**: Asegura que los datos ingresados sean correctos y previene errores con un flujo de control robusto.
- 🚀**Optimización en la Consulta de Datos**: Uso de *Derived Queries* y métodos de resumen para optimizar el rendimiento y precisión en las estadísticas.

## 🛠️Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación.
- **Spring Boot**: Framework para crear aplicaciones basadas en Spring.
- **PostgreSQL**: Base de datos relacional utilizada para almacenar información de libros y autores.
- **Hibernate**: Para la gestión de persistencia y mapeo de objetos relacionales (ORM).


## 🛠️Instalación y Configuración

### ⚙️Requisitos Previos
- Java 17 o superior.
- PostgreSQL con una base de datos configurada para el proyecto (ver archivo `application.properties`).
- IntelliJ IDEA (recomendado) o cualquier IDE compatible con Java y Spring Boot.

### 🔧Configuración
1. Clona este repositorio.
2. Configura los detalles de la base de datos en `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://tu_localhost:tu_Port/tu_nombre_Base_Datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```
   
4. Crea una base de datos en PostgreSQL (en mi caso utilicé la versión 17).
6. Ejecuta la aplicación desde tu IDE.

## 📖Guía de Uso

### 📝Menú Principal
Una vez iniciada la aplicación, se muestra un menú interactivo en la consola:

```markdown
╔════════════════════════════════════════════╗
║                 Liter_Alura                ║
║            Tu Biblioteca Virtual           ║
╚════════════════════════════════════════════╝
1 - Buscar Libro por Título
2 - Listar Libros Registrados
3 - Listar Autores Registrados
4 - Listar Autores vivos en un determinado año
5 - Listar Libros por Idioma

0 - Salir

Opcion:
```

### 🚀Funcionalidades
1. **Buscar Libro por Título**: Realiza una búsqueda por coincidencia parcial del título en la API de Gutendex, luego la persiste en la base de datos.

![image](https://github.com/user-attachments/assets/afe4f377-b0fa-44a1-9a7d-fe259588280b)


2. **Listar Libros Registrados**: Muestra una lista de todos los libros en el catálogo.

![image](https://github.com/user-attachments/assets/ac79366c-4c9a-4be0-85cd-5d68d096a49b)


3. **Listar Autores Registrados**: Muestra una lista de autores junto con sus datos relevantes.

![image](https://github.com/user-attachments/assets/cd423a91-c915-4a06-b6f9-a4a409e33c92)


4. **Listar Autores vivos en un determinado año**: Permite al usuario ingresar un año y ver los autores que aún vivían en esa fecha, basándose en la fecha de nacimiento y fallecimiento registrada.

![image](https://github.com/user-attachments/assets/00f1467d-1bfb-4dfc-876d-c7e0ae8c16d6)


5. **Listar Libros por Idioma**: Muestra libros disponibles en un idioma específico. Los idiomas deben ingresarse en formato ISO 639-1 (ej., es para español).

![image](https://github.com/user-attachments/assets/368feb7d-8fb3-4315-97c0-257b6e2e5900)



