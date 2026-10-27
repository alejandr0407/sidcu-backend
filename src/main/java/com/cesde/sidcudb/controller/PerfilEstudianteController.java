package com.cesde.sidcudb.controller;

import com.cesde.sidcudb.model.entity.PerfilEstudiante;
import com.cesde.sidcudb.service.PerfilEstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles-estudiante")
public class PerfilEstudianteController {

    private final PerfilEstudianteService perfilEstudianteService;

    public PerfilEstudianteController(PerfilEstudianteService perfilEstudianteService) {
        this.perfilEstudianteService = perfilEstudianteService;
    }

    @GetMapping
    public ResponseEntity<List<PerfilEstudiante>> listar() {
        return ResponseEntity.ok(perfilEstudianteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilEstudiante> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(perfilEstudianteService.buscarPorId(id));
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<PerfilEstudiante> buscarPorEstudianteId(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(perfilEstudianteService.buscarPorEstudianteId(estudianteId));
    }

    @PostMapping
    public ResponseEntity<PerfilEstudiante> crear(@RequestBody PerfilEstudiante perfilEstudiante) {
        PerfilEstudiante creado = perfilEstudianteService.crear(perfilEstudiante);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilEstudiante> actualizar(@PathVariable Long id,
                                                     @RequestBody PerfilEstudiante perfilEstudiante) {
        return ResponseEntity.ok(perfilEstudianteService.actualizar(id, perfilEstudiante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        perfilEstudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}