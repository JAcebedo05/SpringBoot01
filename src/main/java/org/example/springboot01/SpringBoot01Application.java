package org.example.springboot01;

// Importamos la clase "SpringApplication" desde el paquete "org.springframework.boot"
// Esta clase es el punto de entrada para iniciar una aplicación Spring Boot

import org.springframework.boot.SpringApplication;

// Importamos la anotación "@SpringBootApplication" desde el paquete "org.springframework.boot.autoconfigure"
// Esta anotación se utiliza para marcar una clase como una aplicación Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotamos la clase "SpringBoot01Application" con "@SpringBootApplication"
// Esto indica que esta clase es la clase principal de la aplicación Spring Boot
@SpringBootApplication
public class SpringBoot01Application {

    // El método "main" es el punto de entrada para cualquier aplicación Java
    // Se utiliza aquí para iniciar la aplicación Spring Boot
    public static void main(String[] args) {
        // Llamamos al método estático "run" de la clase "SpringApplication"
        // Esto inicia la aplicación Spring Boot
        // Se pasa la clase actual y cualquier argumento de línea de comandos
        SpringApplication.run(SpringBoot01Application.class, args);
    }

}
