package com.example.examenupeu.dao;

import java.util.List;
import java.util.Optional;

import com.example.examenupeu.entity.Marca;

public interface MarcaDao {
    Marca create(Marca m);
    Marca update(Marca m);
    void delete(Long id);
    Optional<Marca> read(Long id);
    List<Marca> readAll();
}
