package com.chandilove.appchl.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Blob;
import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PublicacionDTO{
    private Long id;
    private LocalDateTime fechaPublicacion;

    private LocalDateTime fechaActualizacion;

    private String descripcion;

    @NotNull(message = "Cargue la imagen de la publicación")
    private byte[] imagen;

    @NotNull(message = "Ingrese el usuario quien crea la publicación")
    private Long idUser;

}
