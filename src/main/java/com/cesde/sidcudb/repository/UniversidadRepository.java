
package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {

    List<Universidad> findByCiudad(String ciudad);

    Optional<Universidad> findByNombre(String nombre);
}
