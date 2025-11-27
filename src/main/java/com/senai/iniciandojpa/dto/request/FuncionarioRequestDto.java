package com.senai.iniciandojpa.dto.request;

public record FuncionarioRequestDto (
        String nome,
        EnderecoRequestDto endereco
) {
}
