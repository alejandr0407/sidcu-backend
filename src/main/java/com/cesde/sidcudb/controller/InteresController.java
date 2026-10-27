package com.cesde.sidcudb.controller;

import com.cesde.sidcudb.model.embeddable.InteresId;
import com.cesde.sidcudb.model.entity.Interes;
import com.cesde.sidcudb.service.InteresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intereses")
public class InteresController {

    private final InteresService interesService;

    public InteresController(InteresService interesService) {
        this.interesService = interesService;
    }

    @GetMapping
    public ResponseEntity<List<Interes>> listar() {
        return ResponseEntity.ok(interesService.listar());
    }

    @GetMapping("/{estudianteId}/{carreraId}")
    public ResponseEntity<Interes> buscarPorId(@PathVariable Long estudianteId,
                                             @PathVariable Long carreraId) {
        InteresId interesId = new InteresId();
        interesId.setEstudianteId(estudianteId);
        interesId.setCarreraId(carreraId);

        return ResponseEntity.ok(interesService.buscarPorId(interesId));
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<Interes>> buscarPorEstudiante(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(interesService.buscarPorEstudianteId(estudianteId));
    }

    @GetMapping("/carrera/{carreraId}")
    public ResponseEntity<List<Interes>> buscarPorCarrera(@PathVariable Long carreraId) {
        return ResponseEntity.ok(interesService.buscarPorCarreraId(carreraId));
    }

    @PostMapping
    public ResponseEntity<Interes> crear(@RequestBody Interes interes) {
        Interes creado = interesService.crear(interes);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{estudianteId}/{carreraId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long estudianteId,
                                        @PathVariable Long carreraId) {
        InteresId interesId = new InteresId();
        interesId.setEstudianteId(estudianteId);
        interesId.setCarreraId(carreraId);

        interesService.eliminar(interesId);
        return ResponseEntity.noContent().build();
    }
}