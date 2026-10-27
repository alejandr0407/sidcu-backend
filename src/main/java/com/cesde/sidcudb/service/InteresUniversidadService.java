package com.cesde.sidcudb.service;

import com.cesde.sidcudb.model.embeddable.InteresUniversidadId;
import com.cesde.sidcudb.model.entity.InteresUniversidad;
import com.cesde.sidcudb.repository.InteresUniversidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresUniversidadService {

    private final InteresUniversidadRepository interesUniversidadRepository;

    public InteresUniversidadService(InteresUniversidadRepository interesUniversidadRepository) {
        this.interesUniversidadRepository = interesUniversidadRepository;
    }

    public List<InteresUniversidad> listar() {
        return interesUniversidadRepository.findAll();
    }

    public InteresUniversidad buscarPorId(InteresUniversidadId id) {
        return interesUniversidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación interés-universidad no encontrada"));
    }

    public List<InteresUniversidad> buscarPorEstudianteId(Long estudianteId) {
        return interesUniversidadRepository.findAll().stream()
                .filter(relacion -> relacion.getEstudiante() != null
                        && relacion.getEstudiante().getId() != null
                        && relacion.getEstudiante().getId().equals(estudianteId))
                .toList();
    }

    public List<InteresUniversidad> buscarPorUniversidadId(Long universidadId) {
        return interesUniversidadRepository.findAll().stream()
                .filter(relacion -> relacion.getUniversidad() != null
                        && relacion.getUniversidad().getId() != null
                        && relacion.getUniversidad().getId().equals(universidadId))
                .toList();
    }

    public InteresUniversidad crear(InteresUniversidad interesUniversidad) {
        if (interesUniversidad.getId() == null) {
            throw new RuntimeException("Debe enviar la clave compuesta de interés-universidad");
        }
        return interesUniversidadRepository.save(interesUniversidad);
    }

    public void eliminar(InteresUniversidadId id) {
        InteresUniversidad relacion = buscarPorId(id);
        interesUniversidadRepository.delete(relacion);
    }
}