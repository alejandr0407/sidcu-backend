package com.cesde.sidcu.model.entity;

import com.cesde.sidcu.model.embeddable.UniversidadCarreraId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "universidad carrera")
public class UniversidadCarrera {

    @EmbeddedId
    private UniversidadCarreraId id = new UniversidadCarreraId();
}