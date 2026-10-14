package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "perfil_estudiante")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
@AllArgsConstructor 
@SuperBuilder
public class PerfilEstudiante extends BaseEntity {
    private String telefono;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
}