package com.chandilove.appchl.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_usuario")
public class TypeUser extends AbstractEntity {

    @Column(name = "tipo", nullable = false, unique = true)
    private String tipoUsuario;
}
