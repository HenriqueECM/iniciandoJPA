package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.UnidadeCurricularRequestDto;
import com.senai.iniciandojpa.dto.response.ProfessorSimplesResponseDto;
import com.senai.iniciandojpa.dto.response.UnidadeCurricularResponseDto;
import com.senai.iniciandojpa.model.exercicioExtra.UnidadeCurricular;
import org.springframework.stereotype.Component;

@Component
public class UnidadeCurricularMapper {
    public UnidadeCurricular paraEntidade (UnidadeCurricularRequestDto request){
        UnidadeCurricular unidadeCurricular = new UnidadeCurricular();

        unidadeCurricular.setNome(request.nome());

        return unidadeCurricular;
    }

    public UnidadeCurricularResponseDto paraResposta (UnidadeCurricular unidadeCurricular){
        return new UnidadeCurricularResponseDto(
                unidadeCurricular.getId(),
                unidadeCurricular.getNome(),
                unidadeCurricular.getProfessores()
                        .stream()
                        .map(p -> new ProfessorSimplesResponseDto(p.getId(), p.getNome(), p.getEmail()))
                        .toList()
        );
    }

}
