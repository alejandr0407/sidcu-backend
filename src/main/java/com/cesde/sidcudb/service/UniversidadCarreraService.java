package com.cesde.sidcudb.service;

import com.cesde.sidcudb.model.embeddable.UniversidadCarreraId;
import com.cesde.sidcudb.model.entity.UniversidadCarrera;
import com.cesde.sidcudb.repository.UniversidadCarreraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversidadCarreraService {

    private final UniversidadCarreraRepository universidadCarreraRepository;

    public UniversidadCarreraService(UniversidadCarreraRepository universidadCarreraRepository) {
        this.universidadCarreraRepository = universidadCarreraRepository;
    }

    public List<UniversidadCarrera> listar() {
        return universidadCarreraRepository.findAll();
    }

    public UniversidadCarrera buscarPorId(UniversidadCarreraId id) {
        return universidadCarreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación universidad-carrera no encontrada"));
    }

    public List<UniversidadCarrera> buscarPorUniversidadId(Long universidadId) {
        return universidadCarreraRepository.findAll().stream()
                .filter(relacion -> relacion.getUniversidad() != null
                        && relacion.getUniversidad().getId() != null
                        && relacion.getUniversidad().getId().equals(universidadId))
                .toList();
    }

    public List<UniversidadCarrera> buscarPorCarreraId(Long carreraId) {
        return universidadCarreraRepository.findAll().stream()
                .filter(relacion -> relacion.getCarrera() != null
                        && relacion.getCarrera().getId() != null
                        && relacion.getCarrera().getId().equals(carreraId))
                .toList();
    }

    public UniversidadCarrera crear(UniversidadCarrera universidadCarrera) {
        if (universidadCarrera.getId() == null) {
            throw new RuntimeException("Debe enviar la clave compuesta universidad-carrera");
        }
        return universidadCarreraRepository.save(universidadCarrera);
    }

    public void eliminar(UniversidadCarreraId id) {
        UniversidadCarrera relacion = buscarPorId(id);
        universidadCarreraRepository.delete(relacion);
    }
}