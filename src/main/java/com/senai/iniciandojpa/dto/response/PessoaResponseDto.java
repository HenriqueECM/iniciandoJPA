package com.senai.iniciandojpa.dto.response;

import java.util.List;

public record PessoaResponseDto (
        Long id,
        String nome,
        DocumentoResponseDto documento
) {
}
