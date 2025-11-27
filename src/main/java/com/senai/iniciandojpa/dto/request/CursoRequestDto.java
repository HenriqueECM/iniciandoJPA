package com.senai.iniciandojpa.dto.request;

import com.senai.iniciandojpa.model.Aluno;
import java.util.List;

public record CursoRequestDto (
        String nome,
        List<Aluno> alunos
) {
}
