package com.company.nomeprojeto.tarefas.dto;

import java.math.BigDecimal;

public class TarefaDTO {
    // -----------------------tab1-----------------------------------
    private Long id;
    private String veiculo;
    private double fatorMult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public double getFatorMult() {
        return fatorMult;
    }

    public void setFatorMult(double fatorMult) {
        this.fatorMult = fatorMult;
    }

}
