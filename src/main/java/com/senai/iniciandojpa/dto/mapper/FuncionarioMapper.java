package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.FuncionarioRequestDto;
import com.senai.iniciandojpa.dto.response.EnderecoResponseDto;
import com.senai.iniciandojpa.dto.response.FuncionarioResponseDto;
import com.senai.iniciandojpa.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {
    public Funcionario paraEntidade (FuncionarioRequestDto request) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(request.nome());

        return funcionario;
    }

    public FuncionarioResponseDto paraResposta (Funcionario funcionario){
        EnderecoResponseDto endereco = new EnderecoResponseDto(
                funcionario.getEndereco().getId(),
                funcionario.getEndereco().getRua(),
                funcionario.getEndereco().getNumero()
        );

        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                endereco
        );
    }
}
