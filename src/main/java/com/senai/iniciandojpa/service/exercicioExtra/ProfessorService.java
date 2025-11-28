package com.senai.iniciandojpa.service.exercicioExtra;

import com.senai.iniciandojpa.dto.mapper.ProfessorMapper;
import com.senai.iniciandojpa.dto.request.ProfessorRequestDto;
import com.senai.iniciandojpa.dto.response.ProfessorResponseDto;
import com.senai.iniciandojpa.model.exercicioExtra.Professor;
import com.senai.iniciandojpa.model.exercicioExtra.UnidadeCurricular;
import com.senai.iniciandojpa.repository.ProfessorRepository;
import com.senai.iniciandojpa.repository.UnidadeCurricularRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorService {
    private final ProfessorMapper mapper;
    private final ProfessorRepository repository;
    private final UnidadeCurricularRepository curricularRepository;

    public ProfessorResponseDto criar (ProfessorRequestDto request){
        if(repository.existsByNome(request.nome())){
            throw new RuntimeException("Professor ja existe no sistema;");
        }

        Professor professor = mapper.paraEntidade(request);

        return mapper.paraResposta(repository.save(professor));
    }

    public ProfessorResponseDto buscarPorId (Long id){
        Professor professor = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Professor não encontrado."));

        return mapper.paraResposta(professor);
    }

    public ProfessorResponseDto cadastrarProfessorUc (Long professorId, Long unidadeCurricularId){
        Professor professor = repository.findById(professorId)
                .orElseThrow(()-> new RuntimeException("Professor não encontrado."));

        UnidadeCurricular unidadeCurricular = curricularRepository.findById(unidadeCurricularId)
                .orElseThrow(()-> new RuntimeException("Unidade curricular não encontrado."));

        if (professor.getUnidadeCurriculares().contains(unidadeCurricular)){
            throw new RuntimeException("Ja existe professor cadastrado nesta unidade curricular.");
        }

        professor.getUnidadeCurriculares().add(unidadeCurricular);

        return mapper.paraResposta(repository.save(professor));
    }
}
