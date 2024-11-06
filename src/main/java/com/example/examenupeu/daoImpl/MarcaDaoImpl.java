package com.example.examenupeu.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examenupeu.dao.MarcaDao;
import com.example.examenupeu.entity.Marca;
import com.example.examenupeu.repository.MarcaRepository;

@Component
public class MarcaDaoImpl implements MarcaDao {
    @Autowired
    private MarcaRepository repository;
    
    @Override
    public Marca create(Marca m) {
        return repository.save(m);
    }

    @Override
    public Marca update(Marca m) {
        return repository.save(m);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Marca> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Marca> readAll() {
        return repository.findAll();
    }
}
