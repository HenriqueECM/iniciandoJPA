package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.CursoRequestDto;
import com.senai.iniciandojpa.dto.response.AlunoSimplesResponseDto;
import com.senai.iniciandojpa.dto.response.CursoResponseDto;
import com.senai.iniciandojpa.model.exercicio3.Curso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CursoMapper {

    public Curso paraEntidade (CursoRequestDto request){
        Curso curso = new Curso();

        curso.setNome(request.nome());

        return curso;
    }

    public CursoResponseDto paraResposta(Curso curso){
        return new CursoResponseDto(
                curso.getId(),
                curso.getNome(),
                curso.getAlunos()
                        .stream()
                        .map(aluno -> new AlunoSimplesResponseDto(aluno.getId(), aluno.getNome()))
                        .toList()
        );
    }
}
