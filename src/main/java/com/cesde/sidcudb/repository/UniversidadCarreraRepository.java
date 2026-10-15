
package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.embeddable.UniversidadCarreraId;
import com.cesde.sidcudb.model.entity.UniversidadCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversidadCarreraRepository extends JpaRepository<UniversidadCarrera, UniversidadCarreraId> {
}
