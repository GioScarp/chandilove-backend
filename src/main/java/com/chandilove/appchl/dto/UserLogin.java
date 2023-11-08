package com.chandilove.appchl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLogin(

        @NotBlank(message = "Ingrese un email")
        @Email(message = "Email es invalido")
        String email,
        @NotBlank(message = "Ingresa una contraseña")
        String password
) {
}
