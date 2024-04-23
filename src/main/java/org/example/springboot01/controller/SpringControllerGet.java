package org.example.springboot01.controller;

// Importaciones necesarias para el controlador
import java.util.Optional; // Para trabajar con valores opcionales

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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
// Hace lo mismo que el @Autowired, poner atributos en final
@RequiredArgsConstructor
public class SpringControllerGet {

    private final SpringService springService;

    @GetMapping("/verPelicula/{idpelicula}")
    public String verPelicula (@PathVariable (value = "idpelicula") long idPelicula) {
        Pelicula p1 = springService.getPelicula(idPelicula);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(p1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
