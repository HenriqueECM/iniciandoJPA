package com.senai.iniciandojpa.dto.response;

import com.senai.iniciandojpa.dto.response.ProfessorSimplesResponseDto;

import java.util.List;

public record UnidadeCurricularResponseDto (
        Long id,
        String nome,
        List<ProfessorSimplesResponseDto> professores
){}

