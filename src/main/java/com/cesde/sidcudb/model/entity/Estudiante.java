package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "estudiantes")
public class Estudiante extends BaseEntity {

    @Column (nullable = false, unique = true, length = 20)
    private String documento;

    @Column (nullable = false, length = 100)
    private String nombre;

    @Column (nullable = false, length = 50)
    private String ciudad;
}