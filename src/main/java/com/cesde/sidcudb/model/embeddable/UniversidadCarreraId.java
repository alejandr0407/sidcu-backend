package com.cesde.sidcu.model.embeddable;

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
public class UniversidadCarreraId implements Serializable {

    @Column(name = "iduniversidad")
    private Long idUniversidad;

    @Column(name = "idcarrera")
    private Long idCarrera;
}