package com.cesde.sidcudb.controller;

import com.cesde.sidcudb.model.embeddable.InteresUniversidadId;
import com.cesde.sidcudb.model.entity.InteresUniversidad;
import com.cesde.sidcudb.service.InteresUniversidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interes-universidad")
public class InteresUniversidadController {

    private final InteresUniversidadService interesUniversidadService;

    public InteresUniversidadController(InteresUniversidadService interesUniversidadService) {
        this.interesUniversidadService = interesUniversidadService;
    }

    @GetMapping
    public ResponseEntity<List<InteresUniversidad>> listar() {
        return ResponseEntity.ok(interesUniversidadService.listar());
    }

    @GetMapping("/{estudianteId}/{universidadId}")
    public ResponseEntity<InteresUniversidad> buscarPorId(@PathVariable Long estudianteId,
                                                         @PathVariable Long universidadId) {
        InteresUniversidadId id = new InteresUniversidadId();
        id.setEstudianteId(estudianteId);
        id.setUniversidadId(universidadId);

        return ResponseEntity.ok(interesUniversidadService.buscarPorId(id));
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<InteresUniversidad>> buscarPorEstudiante(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(interesUniversidadService.buscarPorEstudianteId(estudianteId));
    }

    @GetMapping("/universidad/{universidadId}")
    public ResponseEntity<List<InteresUniversidad>> buscarPorUniversidad(@PathVariable Long universidadId) {
        return ResponseEntity.ok(interesUniversidadService.buscarPorUniversidadId(universidadId));
    }

    @PostMapping
    public ResponseEntity<InteresUniversidad> crear(@RequestBody InteresUniversidad interesUniversidad) {
        InteresUniversidad creada = interesUniversidadService.crear(interesUniversidad);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{estudianteId}/{universidadId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long estudianteId,
                                        @PathVariable Long universidadId) {
        InteresUniversidadId id = new InteresUniversidadId();
        id.setEstudianteId(estudianteId);
        id.setUniversidadId(universidadId);

        interesUniversidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}