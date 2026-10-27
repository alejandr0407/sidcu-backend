package com.cesde.sidcudb.service;

import com.cesde.sidcudb.model.entity.Estudiante;
import com.cesde.sidcudb.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    public Estudiante buscarPorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public Estudiante buscarPorDocumento(String documento) {
        return estudianteRepository.findByDocumento(documento)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public Estudiante crear(Estudiante estudiante) {
        if (estudianteRepository.existsByDocumento(estudiante.getDocumento())) {
            throw new RuntimeException("Ya existe un estudiante con ese documento");
        }

        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizar(Long id, Estudiante datos) {
        Estudiante estudiante = buscarPorId(id);

        estudianteRepository.findByDocumento(datos.getDocumento())
                .filter(existente -> !existente.getId().equals(id))
                .ifPresent(existente -> {
                    throw new RuntimeException("El documento ya pertenece a otro estudiante");
                });

        estudiante.setDocumento(datos.getDocumento());
        estudiante.setNombre(datos.getNombre());
        estudiante.setCiudad(datos.getCiudad());

        return estudianteRepository.save(estudiante);
    }

    public void eliminar(Long id) {
        Estudiante estudiante = buscarPorId(id);
        estudianteRepository.delete(estudiante);
    }
}