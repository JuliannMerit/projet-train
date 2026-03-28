package com.example.projettrain.api;

import com.example.projettrain.api.error.Exceptions;
import jakarta.validation.constraints.Min;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrôleur de démonstration pour illustrer l'error handler.
 * URL:
 * - GET /api/demo/not-found -> 404 + JSON
 * - GET /api/demo/bad-request -> 400 + JSON
 * - GET /api/demo/gares/{id} avec id <= 0 -> 400 (validation)
 */
@RestController
@RequestMapping("/api/demo")
@Validated
@Profile("!prod")
public class DemoController {

    @GetMapping("/not-found")
    public String notFound() {
        throw new Exceptions.NotFoundException("Ressource introuvable");
    }

    @GetMapping("/bad-request")
    public String badRequest() {
        throw new Exceptions.BadRequestException("Requête invalide");
    }

    @GetMapping("/gares/{id}")
    public String getGare(@PathVariable @Min(1) long id) {
        return "gare-" + id;
    }
}
