
package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false, unique = true, length = 20)
    private String documento;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String ciudad;

    @JsonIgnore
    @OneToMany(mappedBy = "estudiante")
    private List<Interes> intereses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "estudiante")
    private List<InteresUniversidad> interesesUniversidad = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "estudiante")
    private PerfilEstudiante perfil;
}
