package com.senai.iniciandojpa.dto.request;

public record UnidadeCurricularRequestDto (
        String nome
){}

public record UnidadeCurricularResponseDto (
        Long id,
        String nome
){}