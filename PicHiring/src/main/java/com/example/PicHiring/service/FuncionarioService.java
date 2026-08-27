package com.example.PicHiring.service;

import com.example.PicHiring.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class FuncionarioService {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    private Long proximoId = 1L;

    public Funcionario cadastrar(Funcionario funcionario) {

        if (funcionario.getNome() == null || funcionario.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }

        if (funcionario.getEmail() == null || funcionario.getEmail().isBlank()) {
            throw new IllegalArgumentException("E-mail é obrigatório.");
        }

        if (funcionario.getCargo() == null || funcionario.getCargo().isBlank()) {
            throw new IllegalArgumentException("Cargo é obrigatório.");
        }

        funcionario.setId(proximoId);
        proximoId++;

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

   public List<Funcionario> buscarPorNome(String nome) {
        return funcionarios.stream()
            .filter(f -> f.getNome() != null && f.getNome().toLowerCase().contains(nome.toLowerCase()))
            .toList();
    }

    public List<Funcionario> buscarPorCargo(String cargo) {
        return funcionarios.stream()
            .filter(f -> f.getCargo() != null && f.getCargo().equalsIgnoreCase(cargo))
            .toList();
    }

    public List<Funcionario> buscarPorStatus(String status) {
        return funcionarios.stream()
            .filter(f -> f.getStatus() != null && f.getStatus().equalsIgnoreCase(status))
            .toList();
    }

    public Funcionario atualizarCompleto(Long id, Funcionario dadosNovos) {

        Funcionario funcionarioExistente = buscarPorId(id);
        if (funcionarioExistente == null) {
            return null;
        }

        if (dadosNovos.getNome() == null || dadosNovos.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (dadosNovos.getEmail() == null || dadosNovos.getEmail().isBlank()) {
            throw new IllegalArgumentException("E-mail é obrigatório.");
        }
        if (dadosNovos.getCargo() == null || dadosNovos.getCargo().isBlank()) {
            throw new IllegalArgumentException("Cargo é obrigatório.");
        }

        funcionarioExistente.setNome(dadosNovos.getNome());
        funcionarioExistente.setEmail(dadosNovos.getEmail());
        funcionarioExistente.setTelefone(dadosNovos.getTelefone());
        funcionarioExistente.setCargo(dadosNovos.getCargo());
        funcionarioExistente.setDepartamento(dadosNovos.getDepartamento());
        funcionarioExistente.setSalario(dadosNovos.getSalario());
        funcionarioExistente.setCidade(dadosNovos.getCidade());
        funcionarioExistente.setStatus(dadosNovos.getStatus());

        return funcionarioExistente;
    }

    public Funcionario atualizarParcial(Long id, Funcionario dadosParciais) {

        Funcionario funcionarioExistente = buscarPorId(id);
        if (funcionarioExistente == null) {
            return null;
        }

        if (dadosParciais.getNome() != null) {
            funcionarioExistente.setNome(dadosParciais.getNome());
        }
        if (dadosParciais.getEmail() != null) {
            funcionarioExistente.setEmail(dadosParciais.getEmail());
        }
        if (dadosParciais.getTelefone() != null) {
            funcionarioExistente.setTelefone(dadosParciais.getTelefone());
        }
        if (dadosParciais.getCargo() != null) {
            funcionarioExistente.setCargo(dadosParciais.getCargo());
        }
        if (dadosParciais.getDepartamento() != null) {
            funcionarioExistente.setDepartamento(dadosParciais.getDepartamento());
        }
        if (dadosParciais.getSalario() != null) {
            funcionarioExistente.setSalario(dadosParciais.getSalario());
        }
        if (dadosParciais.getCidade() != null) {
            funcionarioExistente.setCidade(dadosParciais.getCidade());
        }
        if (dadosParciais.getStatus() != null) {
            funcionarioExistente.setStatus(dadosParciais.getStatus());
        }

        return funcionarioExistente;
    }

    public boolean excluir(Long id) {
        Funcionario funcionario = buscarPorId(id);
        if (funcionario == null) {
            return false;
        }
        funcionarios.remove(funcionario);
        return true;
    }
}