package com.chandilove.appchl.dto;

import com.chandilove.appchl.models.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserPersonDTO extends UserDTO {
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Apellido es obligatorio")
    private String apellido;
    @NotNull(message = "Fecha nacimiento es obligatoria")
    private LocalDate fechaNacimiento;
    private Gender gender;
}
