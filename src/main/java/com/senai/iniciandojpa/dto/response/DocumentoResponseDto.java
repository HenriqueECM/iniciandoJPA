package com.senai.iniciandojpa.dto.response;

import com.senai.iniciandojpa.model.exercicio1.TipoDocumento;

public record DocumentoResponseDto(
        Long id,
        Long numero,
        TipoDocumento tipo
) {
}
