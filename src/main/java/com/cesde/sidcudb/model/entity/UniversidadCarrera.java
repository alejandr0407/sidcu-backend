package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import com.cesde.sidcudb.model.embeddable.UniversidadCarreraId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "universidad_carrera")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
@AllArgsConstructor 
@SuperBuilder
public class UniversidadCarrera extends BaseEntity { // <--- Extiende de BaseEntity

    @EmbeddedId
    private UniversidadCarreraId id;
}