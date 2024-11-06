package com.example.examenupeu.service;

import java.util.List;
import java.util.Optional;

import com.example.examenupeu.entity.Coche;

public interface CocheService {
    Coche create(Coche c);
    Coche update(Coche c);
    void delete(Long id);
    Optional<Coche> read(Long id);
    List<Coche> readAll();
}
