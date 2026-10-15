
package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    Optional<Carrera> findByNombre(String nombre);

    List<Carrera> findByArea(String area);
}
