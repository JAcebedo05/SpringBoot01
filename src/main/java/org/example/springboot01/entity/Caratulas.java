package org.example.springboot01.entity;

// Importaciones para las anotaciones de JPA y Lombok
import jakarta.persistence.*;
import lombok.AllArgsConstructor; // Para crear un constructor que recibe todos los campos
import lombok.Data; // Para generar automáticamente getters, setters, equals, hashCode y toString
import lombok.NoArgsConstructor; // Para crear un constructor sin argumentos

// Anotación para agregar automáticamente métodos comunes como getters y setters
@Data
// Anotación para indicar que esta clase es una entidad de JPA
@Entity
// Anotación para especificar la tabla en la base de datos asociada a esta entidad
@Table(name = "caratulas")
// Anotación para crear un constructor sin argumentos
@NoArgsConstructor
// Anotación para crear un constructor que recibe todos los campos
@AllArgsConstructor
public class Caratulas {

    // Relación uno a uno con la entidad Pelicula
    @OneToOne
    @JoinTable(name = "idpelicula")
    private Pelicula peliculas;

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    @Id // Id de la tabla.
    @Column(name = "idcaratulas")
    private long idCaratulas;

    @Column(name = "idpelicula")
    private long idPelicula;

    @Column(name = "imagen")
    private String imagen;

}
