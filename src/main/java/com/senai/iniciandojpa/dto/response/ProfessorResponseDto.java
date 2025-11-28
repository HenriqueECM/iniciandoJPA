package com.senai.iniciandojpa.dto.response;

import java.util.List;

public record ProfessorResponseDto (
        Long id,
        String nome,
        String email,
        List<UnidadeCurricularSimplesResponseDto> unidadeCurriculares

) {
}

