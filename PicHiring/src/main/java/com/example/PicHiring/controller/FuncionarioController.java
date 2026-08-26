package com.example.PicHiring.controller;

import com.example.PicHiring.model.Funcionario;
import com.example.PicHiring.service.FuncionarioService;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // post
    @PostMapping
    public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario funcionario) {

        Funcionario funcionarioCadastrado = funcionarioService.cadastrar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(funcionarioCadastrado);
    }

    // get
    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioService.listarTodos();
    }

    // Buscar conta por id
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {

        Funcionario funcionario = funcionarioService.buscarPorId(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionario);
    }
}