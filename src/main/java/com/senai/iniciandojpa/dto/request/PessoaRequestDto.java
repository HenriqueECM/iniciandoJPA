package com.senai.iniciandojpa.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaRequestDto(
        @NotNull(message = "O nome não está inserido")
        @NotBlank(message = "O nome deve ser informado.")
        String nome,

        DocumentoRequestDto documento
) {
}
