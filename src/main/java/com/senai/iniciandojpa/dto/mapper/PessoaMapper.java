package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.PessoaRequestDto;
import com.senai.iniciandojpa.dto.response.DocumentoResponseDto;
import com.senai.iniciandojpa.dto.response.PessoaResponseDto;
import com.senai.iniciandojpa.model.Documento;
import com.senai.iniciandojpa.model.Pessoa;
import com.senai.iniciandojpa.repository.DocumentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public Pessoa paraEntidade (PessoaRequestDto request){
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(request.nome());

        return pessoa;
    }

    public PessoaResponseDto paraResposta (Pessoa pessoa) {

        DocumentoResponseDto response = new DocumentoResponseDto(
                pessoa.getDocumento().getId(),
                pessoa.getDocumento().getNumero(),
                pessoa.getDocumento().getTipoDocumento()
        );

        return new PessoaResponseDto(
                pessoa.getId(),
                pessoa.getNome(),
                response
        );
    }
}
