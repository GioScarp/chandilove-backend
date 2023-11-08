package com.chandilove.appchl.infra.handlers;

import com.chandilove.appchl.infra.exceptions.ImageSizeException;
import com.chandilove.appchl.infra.exceptions.ObjectValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> ObjectValidationException(ObjectValidationException exception) {
        ExceptionRepresentation errores =ExceptionRepresentation.builder()
                .errorMessage("Se ha producido una excepción en las validaciones")
                .errorSource(exception.getViolationSource())
                .validationErrors(exception.getViolations())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errores);
    }

    @ExceptionHandler(ImageSizeException.class)
    public ResponseEntity<ExceptionRepresentation> ImageSizeException(ImageSizeException exception){
        ExceptionRepresentation errores = ExceptionRepresentation.builder()
                .errorMessage("El tamaño de la imagen es muy grande, debe ser menor a 2MB")
                .errorSource(exception.getFileName())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errores);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ExceptionRepresentation> IOException(IOException exception){
        ExceptionRepresentation errores = ExceptionRepresentation.builder()
                .errorMessage("Error al procesar la información. G")
                .errorSource(exception.getMessage())
                .build();
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .contentType(MediaType.APPLICATION_JSON)
            .body(errores);
    }

}
