package com.example.contrato.services;


import com.example.contrato.models.entities.Contrato;

import java.util.List;
import java.util.Optional;

public interface ContratoService {
    List<Contrato> findAll();
    Optional<Contrato> findById(Long id);
    Contrato save(Contrato contrato);
    void deleteById(Long id);
}
