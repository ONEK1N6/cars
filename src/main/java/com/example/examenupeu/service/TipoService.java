package com.example.examenupeu.service;

import java.util.List;
import java.util.Optional;

import com.example.examenupeu.entity.Tipo;

public interface TipoService {
    Tipo create(Tipo t);
    Tipo update(Tipo t);
    void delete(Long id);
    Optional<Tipo> read(Long id);
    List<Tipo> readAll();
}
