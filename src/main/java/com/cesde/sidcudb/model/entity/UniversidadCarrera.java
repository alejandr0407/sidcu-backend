package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.embeddable.UniversidadCarreraId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "universidad_carrera")
public class UniversidadCarrera {

    @EmbeddedId
    private UniversidadCarreraId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("universidadId")
    @JoinColumn(name = "universidad_id")
    private Universidad universidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("carreraId")
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public UniversidadCarrera() {
    }

    public UniversidadCarrera(
            UniversidadCarreraId id,
            Universidad universidad,
            Carrera carrera
    ) {
        this.id = id;
        this.universidad = universidad;
        this.carrera = carrera;
    }

    public UniversidadCarreraId getId() {
        return id;
    }

    public void setId(UniversidadCarreraId id) {
        this.id = id;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}