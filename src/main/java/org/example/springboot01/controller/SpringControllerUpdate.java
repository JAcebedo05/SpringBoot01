package org.example.springboot01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot01.entity.Pelicula;
import org.example.springboot01.repository.Pelicularepository;
import org.example.springboot01.service.SpringService;
import org.springframework.web.bind.annotation.*;


// Anotación para definir una clase como controlador REST
@RestController
// Anotación para habilitar el registro (logging) usando Lombok
@Slf4j
// Hace lo mismo que el @Autowired, poner atributos en final
@RequiredArgsConstructor
public class SpringControllerUpdate {

    private final SpringService springService;

    @PutMapping("/actualizarPelicula/{idpelicula}")
    public String updatePelicula(@PathVariable(value = "idpelicula") long idPelicula,
                                 @RequestBody String json) {
        return springService.updatePelicula(idPelicula, json);
    }

    @PutMapping("/actualizarActor/{idactores}")
    public String updateActores(@PathVariable(value = "idactores") long idActores,
                                 @RequestBody String json) {
        return springService.updateActores(idActores, json);
    }

    @PutMapping("/actualizarVenta/{idventas}")
    public String updateVentas(@PathVariable(value = "idventas") long idVentas,
                                @RequestBody String json) {
        return springService.updateVentas(idVentas, json);
    }

    @PutMapping("/actualizarDirector/{iddirectores}")
    public String updateDirector(@PathVariable(value = "iddirectores") long idDirector,
                               @RequestBody String json) {
        return springService.updateDirector(idDirector, json);
    }


}
