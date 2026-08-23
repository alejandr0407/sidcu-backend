package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.InteresUniversidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresUniversidadRepository extends JpaRepository<InteresUniversidad, Long> {
}