package com.example.examenupeu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenupeu.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
