package com.cesde.sidcudb.controller;

import com.cesde.sidcudb.model.embeddable.UniversidadCarreraId;
import com.cesde.sidcudb.model.entity.UniversidadCarrera;
import com.cesde.sidcudb.service.UniversidadCarreraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universidad-carrera")
public class UniversidadCarreraController {

    private final UniversidadCarreraService universidadCarreraService;

    public UniversidadCarreraController(UniversidadCarreraService universidadCarreraService) {
        this.universidadCarreraService = universidadCarreraService;
    }

    @GetMapping
    public ResponseEntity<List<UniversidadCarrera>> listar() {
        return ResponseEntity.ok(universidadCarreraService.listar());
    }

    @GetMapping("/{universidadId}/{carreraId}")
    public ResponseEntity<UniversidadCarrera> buscarPorId(@PathVariable Long universidadId,
                                                         @PathVariable Long carreraId) {
        UniversidadCarreraId id = new UniversidadCarreraId();
        id.setUniversidadId(universidadId);
        id.setCarreraId(carreraId);

        return ResponseEntity.ok(universidadCarreraService.buscarPorId(id));
    }

    @GetMapping("/universidad/{universidadId}")
    public ResponseEntity<List<UniversidadCarrera>> buscarPorUniversidad(@PathVariable Long universidadId) {
        return ResponseEntity.ok(universidadCarreraService.buscarPorUniversidadId(universidadId));
    }

    @GetMapping("/carrera/{carreraId}")
    public ResponseEntity<List<UniversidadCarrera>> buscarPorCarrera(@PathVariable Long carreraId) {
        return ResponseEntity.ok(universidadCarreraService.buscarPorCarreraId(carreraId));
    }

    @PostMapping
    public ResponseEntity<UniversidadCarrera> crear(@RequestBody UniversidadCarrera universidadCarrera) {
        UniversidadCarrera creada = universidadCarreraService.crear(universidadCarrera);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{universidadId}/{carreraId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long universidadId,
                                        @PathVariable Long carreraId) {
        UniversidadCarreraId id = new UniversidadCarreraId();
        id.setUniversidadId(universidadId);
        id.setCarreraId(carreraId);

        universidadCarreraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}