package com.example.examenupeu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenupeu.entity.Marca;
import com.example.examenupeu.service.MarcaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {

    @Autowired
    private MarcaService service;

    // Método para obtener todas las marcas
    @GetMapping
    public ResponseEntity<List<Marca>> readAll() {
        try {
            List<Marca> marcas = service.readAll();
            if (marcas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(marcas, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear una nueva marca
    @PostMapping
    public ResponseEntity<Marca> crear(@Valid @RequestBody Marca ma) {
        try {
            Marca m = service.create(ma);
            return new ResponseEntity<>(m, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener una marca por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaId(@PathVariable("id") Long id) {
        try {
            Optional<Marca> m = service.read(id);
            if (m.isPresent()) {
                return new ResponseEntity<>(m.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar una marca por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delMarca(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar una marca por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable("id") Long id, @Valid @RequestBody Marca ma) {
        Optional<Marca> m = service.read(id);
        if (m.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(ma), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
