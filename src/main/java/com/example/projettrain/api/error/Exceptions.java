package com.example.projettrain.api.error;

/**
 * Exceptions métier de base.
 * Remarque: on regroupe plusieurs petites classes dans un seul fichier pour éviter la prolifération.
 * Si vous préférez, on peut les séparer en 1 fichier/classe.
 */
public final class Exceptions {

    private Exceptions() {
    }

    /** Ressource inexistante (404). */
    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

    /** Entrée invalide côté client (400) hors validation Bean Validation. */
    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    /** Conflit de données (409) : ex. contrainte d'unicité. */
    public static class ConflictException extends RuntimeException {
        public ConflictException(String message) {
            super(message);
        }
    }
}


