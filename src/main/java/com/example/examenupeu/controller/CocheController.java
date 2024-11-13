package com.example.examenupeu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenupeu.entity.Coche;
import com.example.examenupeu.service.CocheService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/coches")
@CrossOrigin(origins = "http://localhost:4200")
public class CocheController {

    @Autowired
    private CocheService service;
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    // Método para obtener todos los coches
    @GetMapping
    public ResponseEntity<List<Coche>> readAll() {
        try {
            List<Coche> coches = service.readAll();
            if (coches.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(coches, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear un nuevo coche
    @PostMapping
    public ResponseEntity<Coche> crear(@Valid @RequestBody Coche coche) {
        try {
            Coche c = service.create(coche);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener un coche por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Coche> getCocheId(@PathVariable("id") Long id) {
        try {
            Optional<Coche> c = service.read(id);
            if (c.isPresent()) {
                return new ResponseEntity<>(c.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un coche por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delCoche(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un coche por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Coche> updateCoche(@PathVariable("id") Long id, @Valid @RequestBody Coche coche) {
        Optional<Coche> c = service.read(id);
        if (c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(coche), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
