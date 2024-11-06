package com.example.examenupeu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenupeu.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
}
