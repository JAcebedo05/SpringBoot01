package org.example.springboot01.service;

// Importaciones necesarias para trabajar con Jackson y Spring
import com.fasterxml.jackson.core.JsonProcessingException; // Para manejar errores de procesamiento de JSON
import com.fasterxml.jackson.databind.ObjectMapper; // Para convertir JSON a objetos y viceversa
import org.example.springboot01.dto.CaratulasDto; // DTO para carátulas
import org.example.springboot01.dto.DirectorDto; // DTO para directores
import org.example.springboot01.dto.VentasDto; // DTO para ventas
import org.example.springboot01.entity.*; // Importación de todas las entidades del paquete
import org.example.springboot01.repository.*; // Importación de todos los repositorios
import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.stereotype.Service; // Anotación para marcar como servicio

import java.time.LocalDate; // Para trabajar con fechas
import java.util.Optional; // Para manejar valores opcionales

// Anotación para indicar que esta clase es un servicio de Spring
@Service
public class SpringService {

    // Inyección de dependencias para repositorios
    @Autowired
    private Pelicularepository pelicularepository; // Repositorio para la entidad Pelicula
    @Autowired
    private Directoresrepository directoresrepository; // Repositorio para la entidad Director
    @Autowired
    private Ventasrepository ventasrepository; // Repositorio para la entidad Ventas
    @Autowired
    private Caratulasrepository caratulasrepository; // Repositorio para la entidad Caratulas
    @Autowired
    private Actoresrepository actoresrepository; // Repositorio para la entidad Actores

    // Inyección de ObjectMapper para trabajar con JSON
    @Autowired
    private ObjectMapper objectMapper; // Para conversión JSON-Objeto

    // Método para insertar una nueva película en la base de datos
    public String insertarBaseDatos1(String nombre, Integer duracion, String tipopelicula) {

        Pelicula pelicula = new Pelicula();
        pelicula.setNombre(nombre);
        pelicula.setDuracion(duracion);
        pelicula.setTipoPelicula(tipopelicula);
        pelicularepository.save(pelicula);

        return "Se ha hecho bien el proceso.";
    }

    // Método para insertar un nuevo actor en la base de datos
    public String insertarBaseDatos2(long idPelicula, String nombre, String apellido, LocalDate nacimiento, int edad) {

        Actores actores = new Actores();
        actores.setIdPelicula(idPelicula);
        actores.setNombre(nombre);
        actores.setApellido(apellido);
        actores.setNacimiento(nacimiento);
        actores.setEdad(edad);
        actoresrepository.save(actores);

        return "Se ha hecho bien el proceso.";
    }

    // Método para insertar un nuevo director utilizando datos JSON
    public String insertarBaseDatos3(long idPelicula, String json) {

        try {
            DirectorDto directorDto = objectMapper.readValue(json, DirectorDto.class);
            Director director = new Director();
            director.setIdPelicula(idPelicula);
            director.setNombre(directorDto.getNombre());
            director.setApellido(directorDto.getApellido());
            director.setNacimiento(directorDto.getNacimiento());
            director.setEdad(directorDto.getEdad());
            directoresrepository.save(director);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return "Se ha hecho bien el proceso.";

    }

    // Método para insertar una nueva venta utilizando datos JSON
    public String insertarBaseDatos4(long idPelicula, String json) {

        try {
            VentasDto ventasDto = objectMapper.readValue(json, VentasDto.class);
            Ventas ventas = new Ventas();
            ventas.setIdPelicula(idPelicula);
            ventas.setNumventa(ventasDto.getNumventa());
            ventasrepository.save(ventas);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return "Se ha hecho bien el proceso.";

    }

    // Método para insertar una nueva carátula utilizando datos JSON
    public String insertarBaseDatos5(long idPelicula, String json) {

        try {
            CaratulasDto caratulasDto = objectMapper.readValue(json, CaratulasDto.class);
            Caratulas caratulas = new Caratulas();
            caratulas.setIdPelicula(idPelicula);
            caratulas.setImagen(caratulasDto.getImagen());
            caratulasrepository.save(caratulas);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return "Se ha hecho bien el proceso.";

    }

    public Pelicula getPelicula (long idPelicula) {
        Optional<Pelicula> opt = pelicularepository.findById(idPelicula);
        return opt.orElse(null);
    }
}
