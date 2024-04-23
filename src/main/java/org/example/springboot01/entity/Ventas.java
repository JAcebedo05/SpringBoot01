package org.example.springboot01.entity;

// Importaciones necesarias para JPA y Lombok

import jakarta.persistence.*; // Anotaciones de JPA para la persistencia y el mapeo de entidades
import lombok.AllArgsConstructor; // Para el constructor con todos los campos
import lombok.Data; // Para generación automática de getters, setters, equals, hashCode, etc.
import lombok.NoArgsConstructor; // Para el constructor sin argumentos

import java.util.LinkedHashSet; // Para inicializar conjuntos ordenados
import java.util.Set; // Para manejar colecciones de elementos

// Anotación @Data para generar automáticamente métodos básicos (getters, setters, etc.)
@Data
// Anotación @Entity para indicar que esta clase es una entidad de JPA
@Entity
// Anotación @Table para especificar la tabla en la base de datos asociada a esta entidad
@Table(name = "ventas")
// Anotación @NoArgsConstructor para crear un constructor sin argumentos
@NoArgsConstructor
// Anotación @AllArgsConstructor para crear un constructor con todos los campos
@AllArgsConstructor
public class Ventas {

    // Relación muchos a muchos entre ventas y películas
    @ManyToMany
    @JoinTable(name = "ventas_peliculas",
            joinColumns = @JoinColumn(name = "ventas_idVentas"),
            inverseJoinColumns = @JoinColumn(name = "peliculas_idPelicula"))
    private Set<Pelicula> peliculas = new LinkedHashSet<>();

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    @Id // Id de la tabla.
    @Column(name = "idventas")
    private long idVentas;

    @Column(name = "idpelicula")
    private long idPelicula;

    @Column(name = "numventa")
    private String numventa;

}
