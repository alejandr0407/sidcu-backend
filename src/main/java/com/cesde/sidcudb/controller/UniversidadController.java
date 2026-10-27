package com.cesde.sidcudb.controller;

import com.cesde.sidcudb.model.entity.Universidad;
import com.cesde.sidcudb.service.UniversidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universidades")
public class UniversidadController {

    private final UniversidadService universidadService;

    public UniversidadController(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    @GetMapping
    public ResponseEntity<List<Universidad>> listar() {
        return ResponseEntity.ok(universidadService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universidad> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(universidadService.buscarPorId(id));
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<Universidad>> buscarPorCiudad(@PathVariable String ciudad) {
        return ResponseEntity.ok(universidadService.buscarPorCiudad(ciudad));
    }

    @PostMapping
    public ResponseEntity<Universidad> crear(@RequestBody Universidad universidad) {
        Universidad creada = universidadService.crear(universidad);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universidad> actualizar(@PathVariable Long id,
                                                @RequestBody Universidad universidad) {
        return ResponseEntity.ok(universidadService.actualizar(id, universidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        universidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}