package com.senai.iniciandojpa.dto.request;

import com.senai.iniciandojpa.model.exercicio2.Funcionario;

public record EnderecoRequestDto (
        String rua,
        Long numero,

        Funcionario funcionario
){
}
