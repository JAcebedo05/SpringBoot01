package org.example.springboot01.controller;

// Importamos anotaciones y clases necesarias de Spring
import lombok.extern.slf4j.Slf4j; // Para el registro (logging) de mensajes
import org.example.springboot01.service.SpringService; // Servicio que será inyectado
import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.web.bind.annotation.*; // Para las anotaciones de controladores y mapeos de rutas

import java.time.LocalDate; // Para trabajar con fechas

// Anotamos la clase con "@RestController", indicando que es un controlador de REST API
@RestController
// La anotación "@Slf4j" proporciona un logger para el registro de mensajes
@Slf4j
public class SpringController {

    // Inyectamos una instancia de SpringService en el controlador usando "@Autowired"
    @Autowired
    private SpringService springService;

    // Método que maneja una solicitud HTTP GET para insertar una película
    // Toma parámetros de consulta para el nombre, la duración y el tipo de película
    @GetMapping("/insertarPelicula")
    public String insertar1(@RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "duracion") Integer duracion,
            @RequestParam(value = "tipopelicula") String tipopelicula) {

        // Llama a un método del servicio para insertar en la base de datos y retorna el resultado
        return (springService.insertarBaseDatos1(nombre, duracion, tipopelicula));
    }

    // Método que maneja una solicitud HTTP GET para insertar un actor relacionado con una película
    // Toma el ID de la película como parámetro de ruta y otros detalles del actor como parámetros de consulta
    @GetMapping("/insertarActor/{idpelicula}")
    public String insertar2(@PathVariable(value = "idpelicula") Long idPelicula,
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "apellido") String apellido,
            @RequestParam(value = "nacimiento") LocalDate nacimiento,
            @RequestParam(value = "edad") int edad) {

        // Llama a un método del servicio para insertar en la base de datos y retorna el resultado
        return (springService.insertarBaseDatos2(idPelicula, nombre, apellido, nacimiento, edad));
    }

    // Método que maneja una solicitud HTTP POST para insertar un director asociado a una película
    // Toma el ID de la película como parámetro de ruta y un cuerpo JSON con los datos del director
    @PostMapping("/insertarDirector/{idpelicula}")
    public String insertar3(@PathVariable(value = "idpelicula") Long idPelicula,
            @RequestBody() String json) {

        // Llama a un método del servicio para insertar en la base de datos y retorna el resultado
        return (springService.insertarBaseDatos3(idPelicula, json));
    }

    // Método que maneja una solicitud HTTP POST para insertar una venta asociada a una película
    // Toma el ID de la película como parámetro de ruta y un cuerpo JSON con los detalles de la venta
    @PostMapping("/insertarVenta/{idpelicula}")
    public String insertar4(@PathVariable(value = "idpelicula") Long idPelicula,
            @RequestBody() String json) {

        // Llama a un método del servicio para insertar en la base de datos y retorna el resultado
        return (springService.insertarBaseDatos4(idPelicula, json));
    }

    // Método que maneja una solicitud HTTP POST para insertar una carátula asociada a una película
    // Toma el ID de la película como parámetro de ruta y un cuerpo JSON con la información de la carátula
    @PostMapping("/insertarCaratula/{idpelicula}")
    public String insertar5(@PathVariable(value = "idpelicula") Long idPelicula,
            @RequestBody() String json) {

        // Llama a un método del servicio para insertar en la base de datos y retorna el resultado
        return (springService.insertarBaseDatos5(idPelicula, json));
    }

}
