package com.senai.iniciandojpa.service.exercicio3;

import com.senai.iniciandojpa.dto.mapper.AlunoMapper;
import com.senai.iniciandojpa.dto.request.AlunoRequestDto;
import com.senai.iniciandojpa.dto.response.AlunoResponseDto;
import com.senai.iniciandojpa.exception.AlunoNaoExisteException;
import com.senai.iniciandojpa.model.exercicio3.Aluno;
import com.senai.iniciandojpa.model.exercicio3.Curso;
import com.senai.iniciandojpa.repository.AlunoRepository;
import com.senai.iniciandojpa.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AlunoService {
    private final AlunoMapper mapper;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoResponseDto criarAluno (AlunoRequestDto request){
        if (alunoRepository.existsByNome(request.nome())){
            throw new RuntimeException("Aluno Já existe no sistema.");
        }

        Aluno aluno = mapper.paraEntidade(request);

        return mapper.paraResposta(alunoRepository.save(aluno));
    }

    public AlunoResponseDto buscarPorId (Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(AlunoNaoExisteException::new);

        return mapper.paraResposta(aluno);
    }

    public AlunoResponseDto matricular (Long alunoId, Long cursoId){
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(AlunoNaoExisteException::new);

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(()-> new RuntimeException("Curso não encontrado."));

        if (aluno.getCursos().contains(curso)){
            throw new RuntimeException("Aluno já está matriculado neste curso");
        }

        // aqui vai fazer com que adicionar curso ao aluno
        aluno.getCursos().add(curso);

        // aqui vai fazer com que adicionar aluno ao curso
        curso.getAlunos().add(aluno);

        return mapper.paraResposta(alunoRepository.save(aluno));
    }
}
