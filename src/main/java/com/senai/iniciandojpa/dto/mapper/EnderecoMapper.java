package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.EnderecoRequestDto;
import com.senai.iniciandojpa.dto.response.EnderecoResponseDto;
import com.senai.iniciandojpa.model.exercicio2.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    public Endereco paraEntidade (EnderecoRequestDto requestDto){
        Endereco endereco = new Endereco();

        endereco.setRua(requestDto.rua());
        endereco.setNumero(requestDto.numero());
        endereco.setFuncionario(requestDto.funcionario());

        return endereco;
    }

    public EnderecoResponseDto paraResposta (Endereco endereco){
        return new EnderecoResponseDto(
                endereco.getId(),
                endereco.getRua(),
                endereco.getNumero()
        );
    }
}
