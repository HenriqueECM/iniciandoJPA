package com.senai.iniciandojpa.dto.request;

import com.senai.iniciandojpa.model.Funcionario;

public record EnderecoRequestDto (
        String rua,
        Long numero,

        Funcionario funcionario
){
}
