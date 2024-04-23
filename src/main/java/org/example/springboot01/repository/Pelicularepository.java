package org.example.springboot01.repository;

// Importaciones necesarias para Spring Data

import org.example.springboot01.entity.Pelicula; // Entidad que representa a las películas
import org.springframework.data.repository.CrudRepository; // Para operaciones CRUD con repositorios

import java.util.List;

// Interfaz para operaciones CRUD para la entidad "Pelicula"
// Extiende de CrudRepository, especificando el tipo de entidad y el tipo de la clave primaria
public interface Pelicularepository extends CrudRepository<Pelicula, Long> {
    // Al heredar de CrudRepository, esta interfaz tiene métodos para operaciones CRUD básicas
    List<Pelicula> findByNombre(String nombre);
}
