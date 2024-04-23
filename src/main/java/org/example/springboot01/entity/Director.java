package org.example.springboot01.entity;

// Importaciones necesarias para JPA y Lombok

import jakarta.persistence.*;
import lombok.AllArgsConstructor; // Para el constructor con todos los campos
import lombok.Data; // Para métodos automáticos como getters, setters, etc.
import lombok.NoArgsConstructor; // Para el constructor sin argumentos

import java.time.LocalDate; // Para trabajar con fechas
import java.util.LinkedHashSet; // Para inicializar conjuntos ordenados
import java.util.Set; // Para manejar colecciones de elementos

// Anotación @Data para agregar automáticamente métodos comunes como getters y setters
@Data
// Anotación @Entity para indicar que esta clase es una entidad de JPA
@Entity
// Anotación @Table para definir la tabla asociada a esta entidad en la base de datos
@Table(name = "director")
// Anotación @NoArgsConstructor para el constructor sin argumentos
@NoArgsConstructor
// Anotación @AllArgsConstructor para el constructor que toma todos los campos
@AllArgsConstructor
public class Director {

    // Relación muchos a muchos entre directores y películas
    @ManyToMany
    @JoinTable(name = "director_peliculas",
            joinColumns = @JoinColumn(name = "director_iddirectores"),
            inverseJoinColumns = @JoinColumn(name = "peliculas_idPelicula"))
    private Set<Pelicula> peliculas = new LinkedHashSet<>();

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    @Id // Id de la tabla.
    @Column(name = "iddirectores")
    private long idDirectores;

    @Column(name = "idpelicula")
    private long idPelicula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nacimiento")
    private LocalDate nacimiento;

    @Column(name = "edad")
    private int edad;

}
