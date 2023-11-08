package com.chandilove.appchl.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name = "publicaciones")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Publicaciones{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_publicacion")
    private Long id;

    @CreatedDate
    @Column(name = "Fecha_Publicacion", nullable = false, updatable = false)
    private LocalDateTime fechaPublicacion;

    @LastModifiedDate
    @Column(name = "Fecha_Actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "Descripcion")
    private String descripcion;

    @Lob
    @Column(name = "Imagen_publicacion")
    private byte[] imagenPublicacion;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private User user;
}
