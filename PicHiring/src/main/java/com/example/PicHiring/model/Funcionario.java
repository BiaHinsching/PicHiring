package com.example.PicHiring.model;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private String departamento;
    private BigDecimal salario;
    private String cidade;
    private String status;


}
