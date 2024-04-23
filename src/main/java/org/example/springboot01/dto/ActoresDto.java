package org.example.springboot01.dto;

// Importaciones de Lombok para simplificar la escritura del código

import lombok.AllArgsConstructor; // Para el constructor que toma todos los campos como argumentos
import lombok.Data; // Para la generación automática de getters, setters, equals, hashCode, y toString
import lombok.NoArgsConstructor; // Para el constructor sin argumentos

import java.util.Date;

// Anotación @Data para generar automáticamente métodos comunes como getters y setters
@Data
// Anotación @NoArgsConstructor para proporcionar un constructor sin argumentos
@NoArgsConstructor
// Anotación @AllArgsConstructor para crear un constructor que recibe todos los campos como argumentos
@AllArgsConstructor
public class ActoresDto {

    private String nombre;
    private String apellido;
    private int edad;
    private Date nacimiento;

}
