package org.example.springboot01.service;

// Importaciones necesarias para trabajar con Jackson y Spring

import com.fasterxml.jackson.core.JsonProcessingException; // Para manejar errores de procesamiento de JSON
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper; // Para convertir JSON a objetos y viceversa
import org.example.springboot01.dto.*;
import org.example.springboot01.entity.*; // Importación de todas las entidades del paquete
import org.example.springboot01.repository.*; // Importación de todos los repositorios
import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.stereotype.Service; // Anotación para marcar como servicio

import java.time.LocalDate; // Para trabajar con fechas
import java.util.Date;
import java.util.List;
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
    public String insertarBaseDatos2(long idPelicula, String nombre, String apellido, Date nacimiento, int edad) {

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

    public Pelicula getPelicula(long idPelicula) {
        Optional<Pelicula> opt = pelicularepository.findById(idPelicula);
        return opt.orElse(null);
    }

    public String getPelicula2(long idPelicula, String nombre) {

        if (nombre == null) {
            Optional<Pelicula> opt = pelicularepository.findById(idPelicula);
            if (opt.isPresent()) {
                return opt.get().toString();
            } else {
                return "No se ha encontrado en la base de datos";
            }
        } else {
            List<Pelicula> list = pelicularepository.findByNombre(nombre);
            if (list.isEmpty()) {
                return "No se ha encontrado en la base de datos";
            } else {
                return list.toString();
            }
        }

    }

    public Actores getActor(long idActores) {
        Optional<Actores> opt = actoresrepository.findById(idActores);
        return opt.orElse(null);
    }

    public Ventas getVentas(long idVentas) {
        Optional<Ventas> opt = ventasrepository.findById(idVentas);
        return opt.orElse(null);
    }

    public Director getDirector(long idDirector) {
        Optional<Director> opt = directoresrepository.findById(idDirector);
        return opt.orElse(null);
    }

    public String eliminarPelicula(long idPelicula) {
        pelicularepository.deleteById(idPelicula);
        return "La pelicula se ha eliminado correctamente.";
    }

    public String eliminarActor(long idActor) {
        pelicularepository.deleteById(idActor);
        return "El actor se ha eliminado correctamente.";
    }


    public String updatePelicula(long idPelicula, String json) {
        Pelicula p1 = getPelicula(idPelicula);
        PeliculaDto edit;
        if (p1 != null) {
            try {
                edit = objectMapper.readValue(json, PeliculaDto.class);
                p1.setNombre(edit.getNombre());
                p1.setDuracion(edit.getDuracion());
                p1.setTipoPelicula(edit.getTipoPelicula());
                pelicularepository.save(p1);
                return "Película editada correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado la película";
        }
    }

    public String updateActores(long idActores, String json) {
        Actores a1 = getActor(idActores);
        ActoresDto edit;
        if (a1 != null) {
            try {
                edit = objectMapper.readValue(json, ActoresDto.class);
                a1.setNombre(edit.getNombre());
                a1.setApellido(edit.getApellido());
                a1.setNacimiento(edit.getNacimiento());
                a1.setEdad(edit.getEdad());
                actoresrepository.save(a1);
                return "Actor guardado correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado el actor";
        }
    }

    public String updateVentas(long idVentas, String json) {
        Ventas v1 = getVentas(idVentas);
        VentasDto edit;
        if (v1 != null) {
            try {
                edit = objectMapper.readValue(json, VentasDto.class);
                v1.setNumventa(edit.getNumventa());
                ventasrepository.save(v1);
                return "Venta guardada correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado la venta";
        }
    }

    public String updateDirector(long idDirector, String json) {
        Director d1 = getDirector(idDirector);
        DirectorDto edit;
        if (d1 != null) {
            try {
                edit = objectMapper.readValue(json, DirectorDto.class);
                d1.setNombre(edit.getNombre());
                d1.setApellido(edit.getApellido());
                d1.setNacimiento(edit.getNacimiento());
                d1.setEdad(edit.getEdad());
                directoresrepository.save(d1);
                return "Director guardado correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado el director";
        }
    }

}
