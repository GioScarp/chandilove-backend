package com.chandilove.appchl.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Blob;

@Getter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {
    private Long id;

    @NotBlank(message = "EL nombre de usuario es obligatorio")
    private String nombreUsuario;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es valido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 20, message = "La contraseña debe tener min 8 y max 20 caracteres")
    private String password;

    private String biografia;

    @NotBlank(message = "El télefono es obligatorio")
    private String telefono;

    @Setter
    private Blob fotoPerfil;

    @NotBlank(message = "Ingrese una ciudad")
    private String ciudad;

    @NotNull(message = "Ingrese tipo de usuario")
    private Long typeUser;
}
