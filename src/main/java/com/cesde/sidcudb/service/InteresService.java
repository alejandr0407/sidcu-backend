package com.cesde.sidcudb.service;

import com.cesde.sidcudb.model.embeddable.InteresId;
import com.cesde.sidcudb.model.entity.Interes;
import com.cesde.sidcudb.repository.InteresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresService {

    private final InteresRepository interesRepository;

    public InteresService(InteresRepository interesRepository) {
        this.interesRepository = interesRepository;
    }

    public List<Interes> listar() {
        return interesRepository.findAll();
    }

    public Interes buscarPorId(InteresId id) {
        return interesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de interés no encontrado"));
    }

    public List<Interes> buscarPorEstudianteId(Long estudianteId) {
        return interesRepository.findAll().stream()
                .filter(interes -> interes.getEstudiante() != null
                        && interes.getEstudiante().getId() != null
                        && interes.getEstudiante().getId().equals(estudianteId))
                .toList();
    }

    public List<Interes> buscarPorCarreraId(Long carreraId) {
        return interesRepository.findAll().stream()
                .filter(interes -> interes.getCarrera() != null
                        && interes.getCarrera().getId() != null
                        && interes.getCarrera().getId().equals(carreraId))
                .toList();
    }

    public Interes crear(Interes interes) {
        if (interes.getId() == null) {
            throw new RuntimeException("Debe enviar el identificador del interés");
        }
        return interesRepository.save(interes);
    }

    public void eliminar(InteresId id) {
        Interes interes = buscarPorId(id);
        interesRepository.delete(interes);
    }
}