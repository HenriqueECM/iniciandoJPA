package com.senai.iniciandojpa.dto.response;

import java.util.List;

public record ProfessorSimplesResponseDto (
        Long id,
        String nome,
        String email
) {
}

