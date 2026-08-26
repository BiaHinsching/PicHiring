package com.example.PicHiring.service;

import com.example.PicHiring.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class FuncionarioService {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    public Funcionario cadastrar(Funcionario funcionario) {

        if (funcionario.getId() == null) {
            throw new IllegalArgumentException("ID é obrigatório.");
        }

        if (funcionario.getNome() == null || funcionario.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }

        if (funcionario.getEmail() == null || funcionario.getEmail().isBlank()) {
            throw new IllegalArgumentException("E-mail é obrigatório.");
        }

        if (funcionario.getCargo() == null || funcionario.getCargo().isBlank()) {
            throw new IllegalArgumentException("Cargo é obrigatório.");
        }

        boolean idExiste = funcionarios.stream().anyMatch(f -> f.getId().equals(funcionario.getId()));
        if (idExiste) {
            throw new IllegalArgumentException("ID já cadastrado.");
        }

        funcionarios.add(funcionario);
        return funcionario;
    }

    public List<Funcionario> listarTodos() {
        return funcionarios;
    }

    public Funcionario buscarPorId(Long id) {

        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
