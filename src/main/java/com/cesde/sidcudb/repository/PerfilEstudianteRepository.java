
package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.PerfilEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilEstudianteRepository extends JpaRepository<PerfilEstudiante, Long> {
    Optional<PerfilEstudiante> findByEstudiante_Id(Long estudianteId);
}
