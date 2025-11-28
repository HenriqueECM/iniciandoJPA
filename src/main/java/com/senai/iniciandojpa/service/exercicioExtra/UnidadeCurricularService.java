package com.senai.iniciandojpa.service.exercicioExtra;

import com.senai.iniciandojpa.dto.mapper.UnidadeCurricularMapper;
import com.senai.iniciandojpa.dto.request.UnidadeCurricularRequestDto;
import com.senai.iniciandojpa.dto.response.UnidadeCurricularResponseDto;
import com.senai.iniciandojpa.model.exercicioExtra.UnidadeCurricular;
import com.senai.iniciandojpa.repository.UnidadeCurricularRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UnidadeCurricularService {
    private final UnidadeCurricularRepository repository;
    private final UnidadeCurricularMapper mapper;

    public UnidadeCurricularResponseDto criar (UnidadeCurricularRequestDto request){
        if (repository.existsByNome(request.nome())){
            throw new RuntimeException("Unidade curricular já existe.");
        }

        UnidadeCurricular unidadeCurricular = mapper.paraEntidade(request);

        return mapper.paraResposta(repository.save(unidadeCurricular));
    }

    public UnidadeCurricularResponseDto buscarPorId (Long id){
        UnidadeCurricular unidadeCurricular = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Unidade curricular não encontrado."));

        return mapper.paraResposta(unidadeCurricular);
    }

    public List<UnidadeCurricularResponseDto> buscarTodos () {
        return repository.findAll()
                .stream()
                .map(mapper::paraResposta)
                .toList();
    }
}