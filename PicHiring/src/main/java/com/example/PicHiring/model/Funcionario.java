package com.example.PicHiring.model;

import lombok.*;

@Getter
@Setter
public class Funcionario {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private String departamento;
    private Double salario;
    private String cidade;
    private String status;

    // construtores
    public Funcionario() {
    }

    public Funcionario(String nome, String email, String telefone, String cargo, String departamento, Double salario, String cidade, String status) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.cidade = cidade;
        this.status = status;
    }
}
