package com.senai.iniciandojpa.service.exercicio3;

import com.senai.iniciandojpa.dto.mapper.CursoMapper;
import com.senai.iniciandojpa.dto.request.CursoRequestDto;
import com.senai.iniciandojpa.dto.response.CursoResponseDto;
import com.senai.iniciandojpa.model.exercicio3.Curso;
import com.senai.iniciandojpa.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CursoService {
    private CursoMapper mapper;
    private CursoRepository repository;

    public CursoResponseDto criar (CursoRequestDto request){
        if(repository.existsByNome(request.nome())){
            throw new RuntimeException("O curso ja existe.");
        }

        Curso curso = mapper.paraEntidade(request);

        return mapper.paraResposta(repository.save(curso));
    }

    public CursoResponseDto buscarPorId(Long id) {
        Curso curso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado."));

        return mapper.paraResposta(curso);
    }
}
