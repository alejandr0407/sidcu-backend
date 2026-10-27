package com.cesde.sidcudb.controller;

import com.cesde.sidcudb.model.entity.Carrera;
import com.cesde.sidcudb.service.CarreraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> listar() {
        return ResponseEntity.ok(carreraService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(carreraService.buscarPorId(id));
    }

    @GetMapping("/area/{area}")
    public ResponseEntity<List<Carrera>> buscarPorArea(@PathVariable String area) {
        return ResponseEntity.ok(carreraService.buscarPorArea(area));
    }

    @PostMapping
    public ResponseEntity<Carrera> crear(@RequestBody Carrera carrera) {
        Carrera creada = carreraService.crear(carrera);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> actualizar(@PathVariable Long id, @RequestBody Carrera carrera) {
        return ResponseEntity.ok(carreraService.actualizar(id, carrera));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        carreraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}