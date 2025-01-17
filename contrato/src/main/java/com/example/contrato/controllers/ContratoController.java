package com.example.contrato.controllers;

import com.example.contrato.models.entities.Contrato;
import com.example.contrato.services.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Contrato contrato, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();

            result.getFieldErrors().forEach(
                    err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(contrato));
    }

    // Listar todos los contratos
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    // Buscar un contrato por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Contrato> contratoOptional = service.findById(id);
        if (contratoOptional.isPresent()) {
            return ResponseEntity.ok(contratoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Modificar un contrato por su ID
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@Valid @RequestBody Contrato contrato, BindingResult result, @PathVariable Long id) {
        // Validar campos vacíos o inválidos
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        // Buscar el contrato existente
        Optional<Contrato> contratoOptional = service.findById(id);
        if (contratoOptional.isPresent()) {
            Contrato contratoDB = contratoOptional.get();

            // Actualizar los valores del contrato
            contratoDB.setEmpleado(contrato.getEmpleado());
            contratoDB.setEmpresa(contrato.getEmpresa());
            contratoDB.setDuracionMeses(contrato.getDuracionMeses());
            contratoDB.setFechaInicio(contrato.getFechaInicio());

            // Guardar el contrato actualizado
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(contratoDB));
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un contrato por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Contrato> contratoOptional = service.findById(id);
        if (contratoOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

