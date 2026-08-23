package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import com.cesde.sidcudb.model.embeddable.Ubicacion;
import jakarta.persistence.Embedded;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "universidades")
public class Universidad extends BaseEntity {

    @Column(nullable = false, unique = true, length = 150)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String ciudad;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Embedded
    private Ubicacion ubicacion;
}