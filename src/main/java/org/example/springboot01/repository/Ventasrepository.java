package org.example.springboot01.repository;

// Importaciones necesarias para Spring Data

import org.example.springboot01.entity.Ventas; // Entidad que representa las ventas
import org.springframework.data.repository.CrudRepository; // Para operaciones CRUD con repositorios

// Interfaz para operaciones CRUD para la entidad "Ventas"
// Extiende de CrudRepository, especificando el tipo de entidad y el tipo de la clave primaria
public interface Ventasrepository extends CrudRepository<Ventas, Long> {
    // Al heredar de CrudRepository, esta interfaz proporciona métodos para operaciones CRUD básicas
}
