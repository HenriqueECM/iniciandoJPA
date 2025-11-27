package com.senai.iniciandojpa.dto.request;

import com.senai.iniciandojpa.model.Curso;

import java.util.List;

public record AlunoRequestDto (
        String nome,
        List<Curso> cursos
){
}
