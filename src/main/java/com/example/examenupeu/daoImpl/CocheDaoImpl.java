package com.example.examenupeu.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examenupeu.dao.CocheDao;
import com.example.examenupeu.entity.Coche;
import com.example.examenupeu.repository.CocheRepository;

@Component
public class CocheDaoImpl implements CocheDao {
    @Autowired
    private CocheRepository repository;
    
    @Override
    public Coche create(Coche c) {
        return repository.save(c);
    }

    @Override
    public Coche update(Coche c) {
        return repository.save(c);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Coche> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Coche> readAll() {
        return repository.findAll();
    }
}
