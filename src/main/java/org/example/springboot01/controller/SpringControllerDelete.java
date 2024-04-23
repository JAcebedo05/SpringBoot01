package org.example.springboot01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot01.entity.Actores;
import org.example.springboot01.entity.Pelicula;
import org.example.springboot01.repository.Actoresrepository;
import org.example.springboot01.repository.Pelicularepository;
import org.example.springboot01.service.SpringService;
import org.springframework.data.util.Optionals;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// Anotación para definir una clase como controlador REST
@RestController
// Anotación para habilitar el registro (logging) usando Lombok
@Slf4j
// Hace lo mismo que el @Autowired, poner atributos en final
@RequiredArgsConstructor
public class SpringControllerDelete {

    private final SpringService springService;
    private final Pelicularepository pelicularepository;
    private final Actoresrepository actoresrepository;

    @DeleteMapping("/eliminarPelicula/{idpelicula}")
    public String deletePelicula(@PathVariable(value = "idpelicula") long idPelicula) {
        Optional<Pelicula> opt = pelicularepository.findById(idPelicula);
        if (opt.isPresent()) {
            pelicularepository.deleteById(idPelicula);
            return "Se ha borrado correctamente.";
        } else {
            return "No se ha borrado.";
        }

    }

    @DeleteMapping("/eliminarActor/{idactores}")
    public String deleteactor(@PathVariable(value = "idactores") long idActores) {
        Optional<Actores> opt = actoresrepository.findById(idActores);
        if (opt.isPresent()) {
            actoresrepository.deleteById(idActores);
            return "Se ha borrado correctamente.";
        } else {
            return "No se ha borrado.";
        }

    }

}
