package com.cesde.sidcu.model.entity;

import com.cesde.sidcu.model.embeddable.InteresUniversidadId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "interes universidad")
public class InteresUniversidad {

    @EmbeddedId
    private InteresUniversidadId id = new InteresUniversidadId();
}