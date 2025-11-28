package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.AlunoRequestDto;
import com.senai.iniciandojpa.dto.response.AlunoResponseDto;
import com.senai.iniciandojpa.dto.response.CursoResponseDto;
import com.senai.iniciandojpa.dto.response.CursoSimplesResponseDto;
import com.senai.iniciandojpa.model.exercicio3.Aluno;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AlunoMapper {
    public Aluno paraEntidade (AlunoRequestDto request){
        Aluno aluno = new Aluno();

        aluno.setNome(request.nome());

        return aluno;
    }

    public AlunoResponseDto paraResposta(Aluno aluno){
        return new AlunoResponseDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCursos()
                        .stream()
                        .map(c -> new CursoSimplesResponseDto(c.getId(), c.getNome()))
                        .toList()
        );
    }
}
