package com.example.wordfilterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Clase principal de la aplicación de filtrado de mensajes.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class WordFilterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordFilterAppApplication.class, args);
    }

}