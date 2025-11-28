package com.senai.iniciandojpa.dto.response;

import java.util.List;

public record CursoResponseDto(
        Long id,
        String nome,
        List<AlunoSimplesResponseDto> alunos
) {
}