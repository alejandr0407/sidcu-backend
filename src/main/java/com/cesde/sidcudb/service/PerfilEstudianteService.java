package com.cesde.sidcudb.service;

import com.cesde.sidcudb.model.entity.PerfilEstudiante;
import com.cesde.sidcudb.repository.PerfilEstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilEstudianteService {

    private final PerfilEstudianteRepository perfilEstudianteRepository;

    public PerfilEstudianteService(PerfilEstudianteRepository perfilEstudianteRepository) {
        this.perfilEstudianteRepository = perfilEstudianteRepository;
    }

    public List<PerfilEstudiante> listar() {
        return perfilEstudianteRepository.findAll();
    }

    public PerfilEstudiante buscarPorId(Long id) {
        return perfilEstudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil de estudiante no encontrado"));
    }

    public PerfilEstudiante buscarPorEstudianteId(Long estudianteId) {
        return perfilEstudianteRepository.findAll().stream()
                .filter(perfil -> perfil.getEstudiante() != null
                        && perfil.getEstudiante().getId() != null
                        && perfil.getEstudiante().getId().equals(estudianteId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe un perfil para ese estudiante"));
    }

    public PerfilEstudiante crear(PerfilEstudiante perfilEstudiante) {
        return perfilEstudianteRepository.save(perfilEstudiante);
    }

    public PerfilEstudiante actualizar(Long id, PerfilEstudiante datos) {
        PerfilEstudiante perfil = buscarPorId(id);

        perfil.setBiografia(datos.getBiografia());
        perfil.setSitioWeb(datos.getSitioWeb());
        perfil.setEstudiante(datos.getEstudiante());

        return perfilEstudianteRepository.save(perfil);
    }

    public void eliminar(Long id) {
        PerfilEstudiante perfil = buscarPorId(id);
        perfilEstudianteRepository.delete(perfil);
    }
}