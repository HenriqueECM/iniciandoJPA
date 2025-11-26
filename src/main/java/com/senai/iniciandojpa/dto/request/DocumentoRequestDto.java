package com.senai.iniciandojpa.dto.request;

import com.senai.iniciandojpa.model.TipoDocumento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DocumentoRequestDto(
        @NotNull(message = "O número não está inserido")
        @Positive(message = "O número informado deve ser positivo")
        Long numero,

        @NotBlank(message = "O tipo deve ser informado")
        @NotNull(message = "O tipo não está inserido")
        TipoDocumento tipo
) {
}
