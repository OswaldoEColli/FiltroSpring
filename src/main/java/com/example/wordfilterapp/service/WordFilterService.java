package com.example.wordfilterapp.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Servicio que se encarga de filtrar palabras prohibidas en mensajes.
 * Implementado como un bean de Spring para ser inyectado donde sea necesario.
 */
@Service
public class WordFilterService {

    private final List<String> prohibitedWords = Arrays.asList("palabrota", "insulto", "ofensa", "maldición", "improperio");
    private final String replacement = "!#?%@";
    private final int maxProhibitedWords = 3;

    /**
     * Filtra un mensaje reemplazando palabras prohibidas o devolviendo un mensaje
     * de advertencia si excede el límite.
     *
     * @param message El mensaje a filtrar
     * @return El mensaje filtrado o un mensaje de advertencia
     */
    public String filterMessage(String message) {
        List<String> foundProhibitedWords = findProhibitedWords(message);

        if (foundProhibitedWords.size() > maxProhibitedWords) {
            return "¡Atención! Tu mensaje contiene demasiadas palabras prohibidas.";
        }

        String filteredMessage = message;
        for (String word : prohibitedWords) {
            // Busca la palabra con límites de palabra (word boundary)
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            filteredMessage = filteredMessage.replaceAll(regex, replacement);
        }

        return filteredMessage;
    }

    /**
     * Encuentra todas las palabras prohibidas en el mensaje.
     *
     * @param message El mensaje a analizar
     * @return Lista de palabras prohibidas encontradas
     */
    private List<String> findProhibitedWords(String message) {
        List<String> found = new ArrayList<>();
        for (String word : prohibitedWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            if (message.toLowerCase().matches(".*" + regex + ".*")) {
                found.add(word);
            }
        }
        return found;
    }
}