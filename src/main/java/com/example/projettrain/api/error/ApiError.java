package com.example.projettrain.api.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;

/**
 * Payload d'erreur JSON renvoyé par l'API.
 * Objectif: un format stable, simple à consommer côté front.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiError(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        List<ApiFieldError> fieldErrors
) {
    public record ApiFieldError(String field, String message) {
    }
}

