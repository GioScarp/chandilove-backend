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
@Table(name = "fundaciones")
public class Foundation extends AbstractEntity{

    @OneToOne
    @JoinColumn(name = "ID_Usuario", referencedColumnName = "id")
    private User user;
    @Column(name = "Nombre_Fundacion", nullable = false)
    private String nombreFundacion;
    @Column(nullable = false)
    private String direccion;
    @Column(name = "Sitio_web", nullable = false)
    private String sitioWeb;

}
