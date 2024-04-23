package org.example.springboot01.dto;

// Importamos las anotaciones de Lombok para generación automática de código

import lombok.AllArgsConstructor; // Para el constructor que toma todos los campos como argumentos
import lombok.Data; // Para generación automática de getters, setters, equals, hashCode, y toString
import lombok.NoArgsConstructor; // Para el constructor sin argumentos

// Importamos la clase LocalDate para trabajar con fechas
import java.time.LocalDate;

// Anotación @Data para generar automáticamente métodos básicos (getters, setters, etc.)
@Data
// Anotación @NoArgsConstructor para crear un constructor sin argumentos
@NoArgsConstructor
// Anotación @AllArgsConstructor para crear un constructor que recibe todos los campos como argumentos
@AllArgsConstructor
public class DirectorDto {

    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private int edad;

}
