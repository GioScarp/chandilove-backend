package com.chandilove.appchl.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="personas")
public class Person extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "ID_Usuario", referencedColumnName = "id")
    private User user;
    @Column(name = "Nombre_Persona", nullable = false)
    private String nombre;
    @Column(name = "Apellido_Persona", nullable = false)
    private String apellido;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    @Column(name = "Genero_Persona")
    private Gender gender;
}
