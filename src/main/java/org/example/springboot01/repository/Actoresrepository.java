package org.example.springboot01.repository;

// Importación de las interfaces de Spring Data

import org.example.springboot01.entity.Actores; // Entidad que representa a los actores
import org.springframework.data.repository.CrudRepository; // Para operaciones CRUD con repositorios

// Interface para manejar las operaciones CRUD para la entidad "Actores"
// Extiende de CrudRepository y especifica el tipo de entidad y el tipo de la clave primaria
public interface Actoresrepository extends CrudRepository<Actores, Long> {
    // La interfaz no necesita métodos adicionales, ya que hereda las operaciones CRUD básicas
}