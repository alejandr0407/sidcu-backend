package com.cesde.sidcudb.model.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class InteresId implements Serializable {

    @Column (name = "estudiante_id")
    private Long estudianteId;

    @Column (name = "carrera_id")
    private Long carreraId;
}