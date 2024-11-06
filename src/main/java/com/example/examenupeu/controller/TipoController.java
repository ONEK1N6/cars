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

import com.example.examenupeu.entity.Tipo;
import com.example.examenupeu.service.TipoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipos")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoController {

    @Autowired
    private TipoService service;

    // Método para obtener todos los tipos
    @GetMapping
    public ResponseEntity<List<Tipo>> readAll() {
        try {
            List<Tipo> tipos = service.readAll();
            if (tipos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(tipos, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear un nuevo tipo
    @PostMapping
    public ResponseEntity<Tipo> crear(@Valid @RequestBody Tipo tipo) {
        try {
            Tipo t = service.create(tipo);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener un tipo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Tipo> getTipoId(@PathVariable("id") Long id) {
        try {
            Optional<Tipo> t = service.read(id);
            if (t.isPresent()) {
                return new ResponseEntity<>(t.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un tipo por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delTipo(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un tipo por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Tipo> updateTipo(@PathVariable("id") Long id, @Valid @RequestBody Tipo tipo) {
        Optional<Tipo> t = service.read(id);
        if (t.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(tipo), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
