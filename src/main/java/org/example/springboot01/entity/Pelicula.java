package org.example.springboot01.entity;

// Importaciones para JPA y Lombok

import jakarta.persistence.*; // Anotaciones de JPA para mapeo de entidades
import lombok.AllArgsConstructor; // Constructor con todos los campos
import lombok.Data; // Para generación automática de getters, setters, equals, hashCode, etc.
import lombok.NoArgsConstructor; // Constructor sin argumentos
import org.hibernate.annotations.CreationTimestamp; // Anotación para crear timestamps automáticos

import java.util.Date; // Para manejar fechas
import java.util.LinkedHashSet; // Para inicializar conjuntos ordenados
import java.util.Set; // Para manejar colecciones de elementos

// Anotación @Data para generar automáticamente métodos básicos (getters, setters, etc.)
@Data
// Anotación @Entity para indicar que esta clase es una entidad de JPA
@Entity
// Anotación @Table para definir la tabla en la base de datos asociada a esta entidad
@Table(name = "pelicula")
// Anotación @NoArgsConstructor para crear un constructor sin argumentos
@NoArgsConstructor
// Anotación @AllArgsConstructor para crear un constructor con todos los campos
@AllArgsConstructor
public class Pelicula {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    @Id // Id de la tabla.
    @Column(name = "idPelicula")
    private long idPelicula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "duracion")
    private double duracion;

    @CreationTimestamp
    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @Column(name = "tipopelicula")
    private String tipoPelicula;

    // Relación muchos a muchos entre películas y actores
    @ManyToMany(mappedBy = "peliculas")
    private Set<Actores> actoreses = new LinkedHashSet<>();

    // Relación muchos a muchos entre películas y directores
    @ManyToMany(mappedBy = "peliculas")
    private Set<Director> directores = new LinkedHashSet<>();

    // Relación muchos a muchos entre películas y ventas
    @ManyToMany(mappedBy = "peliculas")
    private Set<Ventas> ventas = new LinkedHashSet<>();

    // Relación uno a uno entre películas y carátulas
    @OneToOne(mappedBy = "peliculas")
    private Caratulas caratulas;

}
