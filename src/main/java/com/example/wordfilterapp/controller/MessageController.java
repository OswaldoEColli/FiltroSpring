package com.example.wordfilterapp.controller;

import com.example.wordfilterapp.model.Message;
import com.example.wordfilterapp.service.WordFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador que maneja las solicitudes web para la interfaz gráfica.
 */
@Controller
public class MessageController {

    private final WordFilterService wordFilterService;

    @Autowired
    public MessageController(WordFilterService wordFilterService) {
        this.wordFilterService = wordFilterService;
    }

    /**
     * Muestra el formulario para ingresar mensajes.
     *
     * @param model El modelo que se pasará a la vista
     * @return El nombre de la vista a renderizar
     */
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("message", new Message());
        return "index";
    }

    /**
     * Procesa el mensaje enviado por el usuario.
     *
     * @param message El mensaje enviado por el usuario
     * @param model El modelo que se pasará a la vista
     * @return El nombre de la vista a renderizar
     */
    @PostMapping("/process")
    public String processMessage(@ModelAttribute Message message, Model model) {
        if (message.getContent() != null && !message.getContent().isEmpty()) {
            String filteredContent = wordFilterService.filterMessage(message.getContent());
            model.addAttribute("filteredMessage", filteredContent);
        }
        model.addAttribute("message", new Message());
        return "index";
    }
}