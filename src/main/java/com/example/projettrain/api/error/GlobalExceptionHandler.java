package com.example.projettrain.api.error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

/**
 * Error handler global (API REST).
 * Centralise la conversion Exceptions -> HTTP + JSON.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exceptions.NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(Exceptions.NotFoundException ex, HttpServletRequest request) {
        return build(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI(), null);
    }

    @ExceptionHandler(Exceptions.BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(Exceptions.BadRequestException ex, HttpServletRequest request) {
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI(), null);
    }

    @ExceptionHandler(Exceptions.ConflictException.class)
    public ResponseEntity<ApiError> handleConflict(Exceptions.ConflictException ex, HttpServletRequest request) {
        return build(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<ApiError.ApiFieldError> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(this::toApiFieldError)
                .toList();
        return build(HttpStatus.BAD_REQUEST, "Validation error", request.getRequestURI(), fieldErrors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
        // Gardé simple : message global
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI(), null);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return build(HttpStatus.BAD_REQUEST, "Malformed JSON request", request.getRequestURI(), null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex, HttpServletRequest request) {
        // Par défaut, on évite d'exposer le stacktrace.
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", request.getRequestURI(), null);
    }

    private ResponseEntity<ApiError> build(HttpStatus status, String message, String path, List<ApiError.ApiFieldError> fieldErrors) {
        ApiError body = new ApiError(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path,
                fieldErrors == null || fieldErrors.isEmpty() ? null : fieldErrors
        );
        return new ResponseEntity<>(body, new HttpHeaders(), status);
    }

    private ApiError.ApiFieldError toApiFieldError(FieldError fieldError) {
        String msg = fieldError.getDefaultMessage();
        if (msg == null || msg.isBlank()) {
            msg = "Invalid value";
        }
        return new ApiError.ApiFieldError(fieldError.getField(), msg);
    }
}

