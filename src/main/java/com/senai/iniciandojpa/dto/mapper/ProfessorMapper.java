package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.ProfessorRequestDto;
import com.senai.iniciandojpa.dto.response.ProfessorResponseDto;
import com.senai.iniciandojpa.dto.response.UnidadeCurricularSimplesResponseDto;
import com.senai.iniciandojpa.model.exercicioExtra.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public Professor paraEntidade (ProfessorRequestDto request){
        Professor professor = new Professor();

        professor.setNome(request.nome());
        professor.setEmail(request.email());

        return professor;
    }

    public ProfessorResponseDto paraResposta (Professor professor){
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getUnidadeCurriculares()
                        .stream()
                        .map(uc -> new UnidadeCurricularSimplesResponseDto(uc.getId(), uc.getNome()))
                        .toList()
        );
    }
}
