package com.example.contrato.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name="contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String empleado;

    @NotEmpty
    @Column(nullable = false)
    private String empresa;

    @Column(nullable = false)
    private int duracionMeses;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
