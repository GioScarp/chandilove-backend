package com.chandilove.appchl.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserFundationDTO extends UserDTO {

    private Long UserID;

    @NotBlank(message = "Nombre de la fundación es obligatorio")
    private String nombreFundacion;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    @NotBlank(message = "Sitio web es obligatorio")
    private String sitioWeb;
}
