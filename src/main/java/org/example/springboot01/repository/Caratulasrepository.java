package org.example.springboot01.repository;

// Importación de las interfaces de Spring Data
import org.example.springboot01.entity.Caratulas; // Entidad que representa a las carátulas
import org.springframework.data.repository.CrudRepository; // Para operaciones CRUD con repositorios

// Interfaz para manejar las operaciones CRUD para la entidad "Caratulas"
// Extiende de CrudRepository y especifica el tipo de entidad y el tipo de la clave primaria
public interface Caratulasrepository extends CrudRepository<Caratulas, Long> {
    // La interfaz ya proporciona operaciones CRUD básicas, no se requieren métodos adicionales
}
