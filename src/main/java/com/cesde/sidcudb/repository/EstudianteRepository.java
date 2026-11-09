
package com.cesde.sidcudb.repository;

import com.cesde.sidcudb.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository
        extends JpaRepository<Estudiante, Long> {

    // Buscar por documento
    Optional<Estudiante> findByDocumento(String documento);

    // Verificar si existe un documento
    boolean existsByDocumento(String documento);

    // Buscar por ciudad
    List<Estudiante> findByCiudadIgnoreCase(String ciudad);

    // Buscar por correo
    Optional<Estudiante> findByCorreo(String correo);

    // Verificar si existe un correo
    boolean existsByCorreo(String correo);
}
