package org.example.springboot01.controller;

// Importaciones necesarias para el controlador
import java.util.Optional; // Para trabajar con valores opcionales
import lombok.extern.slf4j.Slf4j; // Para el registro (logging)
import org.example.springboot01.entity.Pelicula; // Entidad Película
import org.example.springboot01.service.SpringService; // Servicio para interactuar con la lógica de negocio
import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.web.bind.annotation.GetMapping; // Anotación para mapear rutas GET
import org.springframework.web.bind.annotation.PathVariable; // Para obtener variables de la ruta

import org.springframework.web.bind.annotation.RestController;

// Anotación para definir una clase como controlador REST
@RestController
// Anotación para habilitar el registro (logging) usando Lombok
@Slf4j
public class SpringControllerGet {

    // Inyectamos SpringService en el controlador usando Autowired
    @Autowired
    private SpringService springService;

    // Método que maneja las solicitudes HTTP GET para obtener detalles de una película por su ID
    @GetMapping("/verPelicula/{idpelicula}")
    public String obtener(@PathVariable("idpelicula") Long idPelicula) {
        // Intentamos obtener la película por su ID usando el servicio
        Optional<Pelicula> optionalPelicula = springService.obtener(idPelicula);

        // Si la película no existe, devolvemos un mensaje indicando que no se encontró
        if (optionalPelicula.isEmpty()) {
            return "La película con ID " + idPelicula + " no existe.";
        }

        // Si la película existe, obtenemos sus detalles
        Pelicula pelicula = optionalPelicula.get();

        // Retornamos una cadena con información básica de la película
        return "Película: " + pelicula.getNombre()
                + ", Duración: " + pelicula.getDuracion()
                + ", Tipo: " + pelicula.getTipoPelicula();
    }
}
