package org.example.springboot01.entity;

// Importaciones de JPA para las anotaciones de mapeo y gestión de la persistencia

import jakarta.persistence.*;
import lombok.AllArgsConstructor; // Anotación para el constructor con todos los campos
import lombok.Data; // Anotación para la generación automática de métodos comunes (getters, setters, etc.)
import lombok.NoArgsConstructor; // Anotación para el constructor sin argumentos

import java.time.LocalDate; // Para trabajar con fechas
import java.util.Date;
import java.util.LinkedHashSet; // Para inicializar el conjunto de películas
import java.util.Set; // Para representar un conjunto de elementos

// Anotación @Data para agregar automáticamente getters, setters, equals, hashCode, y toString
@Data
// Anotación @Entity para indicar que esta clase es una entidad de JPA
@Entity
// Anotación @Table para especificar la tabla de la base de datos asociada a esta entidad
@Table(name = "actores")
// Anotación @NoArgsConstructor para crear un constructor sin argumentos
@NoArgsConstructor
// Anotación @AllArgsConstructor para crear un constructor con todos los campos
@AllArgsConstructor
public class Actores {

    // Configuración de la relación de muchos a muchos entre actores y películas
    @ManyToMany
    @JoinTable(name = "actores_peliculas",
            joinColumns = @JoinColumn(name = "actores_idActores"),
            inverseJoinColumns = @JoinColumn(name = "peliculas_idPelicula"))
    private Set<Pelicula> peliculas = new LinkedHashSet<>();

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    @Id // Id de la tabla.
    @Column(name = "idActores")
    private long idActores;

    @Column(name = "idpelicula")
    private long idPelicula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nacimiento")
    private Date nacimiento;

    @Column(name = "edad")
    private int edad;

}
