package org.example.springboot01.repository;

// Importación de las interfaces de Spring Data

import org.example.springboot01.entity.Director; // Entidad que representa a los directores
import org.springframework.data.repository.CrudRepository; // Para operaciones CRUD con repositorios

// Interfaz para manejar las operaciones CRUD para la entidad "Director"
// Extiende de CrudRepository y especifica el tipo de entidad y el tipo de la clave primaria
public interface Directoresrepository extends CrudRepository<Director, Long> {
    // La interfaz proporciona operaciones CRUD básicas, por lo que no requiere métodos adicionales
}
