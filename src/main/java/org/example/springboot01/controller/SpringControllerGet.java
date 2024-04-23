package org.example.springboot01.controller;

// Importaciones necesarias para el controlador

import java.util.Optional; // Para trabajar con valores opcionales

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j; // Para el registro (logging)
import org.example.springboot01.entity.Actores;
import org.example.springboot01.entity.Pelicula; // Entidad Película
import org.example.springboot01.entity.Ventas;
import org.example.springboot01.service.SpringService; // Servicio para interactuar con la lógica de negocio
import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.web.bind.annotation.GetMapping; // Anotación para mapear rutas GET
import org.springframework.web.bind.annotation.PathVariable; // Para obtener variables de la ruta

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Anotación para definir una clase como controlador REST
@RestController
// Anotación para habilitar el registro (logging) usando Lombok
@Slf4j
// Hace lo mismo que el @Autowired, poner atributos en final
@RequiredArgsConstructor
public class SpringControllerGet {

    private final SpringService springService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/verPelicula/{idpelicula}")
    public String verPelicula(@PathVariable(value = "idpelicula") long idPelicula,
                              @RequestParam(value = "nombre", required = false) String nombre) {
        String p1 = springService.getPelicula2(idPelicula, nombre);
        try {
            return objectMapper.writeValueAsString(p1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/verActor/{idactores}")
    public String verActor(@PathVariable(value = "idactores") long idActores) {
        Actores a1 = springService.getActor(idActores);

        try {
            return objectMapper.writeValueAsString(a1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/verD/{idventas}")
    public String verVentas(@PathVariable(value = "idventas") long idVentas) {
        Ventas v1 = springService.getVentas(idVentas);

        try {
            return objectMapper.writeValueAsString(v1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
