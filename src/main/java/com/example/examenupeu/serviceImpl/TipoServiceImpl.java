package com.example.examenupeu.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenupeu.entity.Tipo;
import com.example.examenupeu.repository.TipoRepository;
import com.example.examenupeu.service.TipoService;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository repository;

    @Override
    public Tipo create(Tipo t) {
        return repository.save(t);
    }

    @Override
    public Tipo update(Tipo t) {
        return repository.save(t);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Tipo> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Tipo> readAll() {
        return repository.findAll();
    }
}
