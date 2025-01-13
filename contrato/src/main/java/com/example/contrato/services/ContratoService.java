package com.example.contrato.services;

import com.example.contrato.models.entities.Contrato;

import java.util.List;
import java.util.Optional;

public interface ContratoService {
    List<Contrato> findAll();
    Optional<Contrato> findById(Integer id);
    Contrato save(Contrato contrato);
    void deleteById(Integer id);
}
