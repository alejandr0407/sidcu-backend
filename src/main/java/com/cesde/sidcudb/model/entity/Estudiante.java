
package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante extends BaseEntity {

    @Column(name = "documento", nullable = false,
            unique = true, length = 20)
    private String documento;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Column(name = "correo", nullable = false,
            unique = true, length = 100)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @OneToMany(mappedBy = "estudiante",
            cascade = CascadeType.REMOVE)
    private List<Interes> intereses = new ArrayList<>();

    @OneToMany(mappedBy = "estudiante",
            cascade = CascadeType.REMOVE)
    private List<InteresUniversidad> interesesUniversidad =
            new ArrayList<>();

    @OneToOne(mappedBy = "estudiante",
            cascade = CascadeType.REMOVE)
    private PerfilEstudiante perfil;
}
