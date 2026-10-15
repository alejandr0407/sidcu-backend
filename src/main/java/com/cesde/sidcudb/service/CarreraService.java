
package com.cesde.sidcudb.service;

import com.cesde.sidcudb.model.entity.Carrera;
import com.cesde.sidcudb.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Carrera> listar() {
        return carreraRepository.findAll();
    }

    public Carrera buscarPorId(Long id) {
        return carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
    }

    public Carrera crear(Carrera carrera) {
        carreraRepository.findByNombre(carrera.getNombre())
                .ifPresent(existente -> {
                    throw new RuntimeException("Ya existe una carrera con ese nombre");
                });

        return carreraRepository.save(carrera);
    }

    public Carrera actualizar(Long id, Carrera datos) {
        Carrera carrera = buscarPorId(id);

        carreraRepository.findByNombre(datos.getNombre())
                .filter(existente -> !existente.getId().equals(id))
                .ifPresent(existente -> {
                    throw new RuntimeException("El nombre ya pertenece a otra carrera");
                });

        carrera.setNombre(datos.getNombre());
        carrera.setArea(datos.getArea());
        carrera.setNivel(datos.getNivel());

        return carreraRepository.save(carrera);
    }

    public void eliminar(Long id) {
        Carrera carrera = buscarPorId(id);
        carreraRepository.delete(carrera);
    }

    public List<Carrera> buscarPorArea(String area) {
        return carreraRepository.findByArea(area);
    }
}
