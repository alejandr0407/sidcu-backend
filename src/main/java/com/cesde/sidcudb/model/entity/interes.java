package com.cesde.sidcu.model.entity;

import com.cesde.sidcu.model.embeddable.InteresId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "interes")
public class Interes {

    @EmbeddedId
    private InteresId id = new InteresId();

    @Column(name = "fecha_interes", nullable = false)
    private LocalDate fechaInteres;
}