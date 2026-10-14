package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "carreras")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
@AllArgsConstructor
@SuperBuilder
public class Carrera extends BaseEntity {
    private String nombre;
    private String descripcion;
}