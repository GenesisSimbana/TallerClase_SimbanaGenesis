package com.example.contrato.services;

import com.example.contrato.models.entities.Contrato;
import com.example.contrato.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    private ContratoRepository repository;

    @Override
    public List<Contrato> findAll() {
        return (List<Contrato>) repository.findAll();
    }

    @Override
    public Optional<Contrato> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Contrato save(Contrato contrato) {
        return repository.save(contrato);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
