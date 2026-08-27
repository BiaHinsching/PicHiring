package com.example.PicHiring.controller;

import com.example.PicHiring.model.Funcionario;
import com.example.PicHiring.service.FuncionarioService;

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

    @GetMapping("/buscar")
    public List<Funcionario> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cargo,
            @RequestParam(required = false) String status) {
            
        if (nome != null) {
            return funcionarioService.buscarPorNome(nome);
        }
        if (cargo != null) {
            return funcionarioService.buscarPorCargo(cargo);
        }
        if (status != null) {
            return funcionarioService.buscarPorStatus(status);
        }

        return funcionarioService.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarCompleto(@PathVariable Long id, @RequestBody Funcionario funcionario) {

        Funcionario atualizado = funcionarioService.atualizarCompleto(id, funcionario);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarParcial(@PathVariable Long id, @RequestBody Funcionario funcionario) {

        Funcionario atualizado = funcionarioService.atualizarParcial(id, funcionario);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        boolean removido = funcionarioService.excluir(id);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}