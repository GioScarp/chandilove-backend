package com.chandilove.appchl.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Blob;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuarios")
public class User extends AbstractEntity{

    @Column(name = "Nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    private String biografia;

    @Column(nullable = false)
    private String telefono;

    @Lob
    @Column(name = "Foto_perfil")
    private byte[] fotoPerfil;

    @Column(nullable = false)
    private String ciudad;

    @Builder.Default
    @Column(nullable = false)
    private Boolean activo = true;

    @OneToOne
    @JoinColumn(name = "tipo_user_id", referencedColumnName = "id")
    private TypeUser typeUser;

    @OneToMany(mappedBy = "user")
    private List<Publicaciones> publicaciones;
}
