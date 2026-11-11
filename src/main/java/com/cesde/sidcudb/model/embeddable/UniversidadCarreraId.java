package com.cesde.sidcudb.model.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UniversidadCarreraId implements Serializable {

    @Column(name = "universidad_id")
    private Long universidadId;

    @Column(name = "carrera_id")
    private Long carreraId;

    public UniversidadCarreraId() {
    }

    public UniversidadCarreraId(Long universidadId, Long carreraId) {
        this.universidadId = universidadId;
        this.carreraId = carreraId;
    }

    public Long getUniversidadId() {
        return universidadId;
    }

    public void setUniversidadId(Long universidadId) {
        this.universidadId = universidadId;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof UniversidadCarreraId otro)) {
            return false;
        }
        return Objects.equals(universidadId, otro.universidadId)
                && Objects.equals(carreraId, otro.carreraId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universidadId, carreraId);
    }
}