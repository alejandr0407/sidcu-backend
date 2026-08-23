package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.PerfilEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilEstudianteRepository extends JpaRepository<PerfilEstudiante, Long> {
}