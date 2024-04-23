package org.example.springboot01.dto;

// Importamos anotaciones de Lombok para reducir el código repetitivo

import lombok.AllArgsConstructor; // Crea un constructor que toma todos los parámetros
import lombok.Data; // Genera getters, setters, equals, hashCode y toString automáticamente
import lombok.NoArgsConstructor; // Crea un constructor sin parámetros (por defecto)

// Anotación @Data para agregar getters, setters, equals, hashCode y toString automáticamente
@Data
// Anotación @NoArgsConstructor para crear un constructor sin argumentos
@NoArgsConstructor
// Anotación @AllArgsConstructor para crear un constructor que toma todos los atributos como argumentos
@AllArgsConstructor
public class CaratulasDto {

    private String imagen;

}
