package com.example.wordfilterapp.console;

import com.example.wordfilterapp.service.WordFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Implementación de la interfaz de consola para la aplicación.
 * Se ejecuta automáticamente cuando se inicia la aplicación.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final WordFilterService wordFilterService;

    @Autowired
    public ConsoleRunner(WordFilterService wordFilterService) {
        this.wordFilterService = wordFilterService;
    }

    /**
     * Ejecuta la aplicación de consola.
     *
     * @param args Argumentos de línea de comandos
     */
    @Override
    public void run(String... args) {
        System.out.println("=== Sistema de Filtrado de Mensajes ===");
        System.out.println("Escribe 'salir' para terminar");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese su mensaje: ");
            String input = scanner.nextLine();

            if ("salir".equalsIgnoreCase(input)) {
                break;
            }

            String filtered = wordFilterService.filterMessage(input);
            System.out.println("Mensaje filtrado: " + filtered);
        }

        System.out.println("¡Hasta luego!");
    }
}