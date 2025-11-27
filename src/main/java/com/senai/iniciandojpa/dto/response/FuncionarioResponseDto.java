package com.senai.iniciandojpa.dto.response;

public record FuncionarioResponseDto (
        Long id,
        String nome,
        EnderecoResponseDto endereco
) {
}
