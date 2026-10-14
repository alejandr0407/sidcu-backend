package com.cesde.sidcudb.model.entity;

import com.cesde.sidcudb.model.base.BaseEntity;
import com.cesde.sidcudb.model.embeddable.InteresUniversidadId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "interes_universidad")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
@AllArgsConstructor 
@SuperBuilder
public class InteresUniversidad extends BaseEntity { 
    @EmbeddedId
    private InteresUniversidadId id;
}