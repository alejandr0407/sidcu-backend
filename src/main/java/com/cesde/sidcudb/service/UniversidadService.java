
package com.cesde.sidcudb.service;

import com.cesde.sidcudb.model.entity.Universidad;
import com.cesde.sidcudb.repository.UniversidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversidadService {

    private final UniversidadRepository universidadRepository;

    public UniversidadService(UniversidadRepository universidadRepository) {
        this.universidadRepository = universidadRepository;
    }

    public List<Universidad> listar() {
        return universidadRepository.findAll();
    }

    public Universidad buscarPorId(Long id) {
        return universidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Universidad no encontrada"));
    }

    public Universidad crear(Universidad universidad) {
        universidadRepository.findByNombre(universidad.getNombre())
                .ifPresent(existente -> {
                    throw new RuntimeException("Ya existe una universidad con ese nombre");
                });

        return universidadRepository.save(universidad);
    }

    public Universidad actualizar(Long id, Universidad datos) {
        Universidad universidad = buscarPorId(id);

        universidadRepository.findByNombre(datos.getNombre())
                .filter(existente -> !existente.getId().equals(id))
                .ifPresent(existente -> {
                    throw new RuntimeException("El nombre ya pertenece a otra universidad");
                });

        universidad.setNombre(datos.getNombre());
        universidad.setCiudad(datos.getCiudad());
        universidad.setTipo(datos.getTipo());
        universidad.setUbicacion(datos.getUbicacion());

        return universidadRepository.save(universidad);
    }

    public void eliminar(Long id) {
        Universidad universidad = buscarPorId(id);
        universidadRepository.delete(universidad);
    }

    public List<Universidad> buscarPorCiudad(String ciudad) {
        return universidadRepository.findByCiudad(ciudad);
    }
}
