package com.senai.iniciandojpa.service.exercicio2;

import com.senai.iniciandojpa.dto.mapper.EnderecoMapper;
import com.senai.iniciandojpa.dto.mapper.FuncionarioMapper;
import com.senai.iniciandojpa.dto.request.FuncionarioRequestDto;
import com.senai.iniciandojpa.dto.response.FuncionarioResponseDto;
import com.senai.iniciandojpa.exception.FuncionarioNaoExisteException;
import com.senai.iniciandojpa.model.exercicio2.Endereco;
import com.senai.iniciandojpa.model.exercicio2.Funcionario;
import com.senai.iniciandojpa.repository.EnderecoRepository;
import com.senai.iniciandojpa.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FuncionarioService {
    private final FuncionarioMapper funcionarioMapper;
    private final EnderecoMapper enderecoMapper;
    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoRepository enderecoRepository;

    public FuncionarioResponseDto criarFuncionario (FuncionarioRequestDto request){
        if (funcionarioRepository.existsByNome(request.nome())){
            throw new RuntimeException("Já existe funcionario com este nome.");
        }

        Funcionario funcionario = funcionarioRepository.save(funcionarioMapper.paraEntidade(request));

        Endereco endereco = enderecoMapper.paraEntidade(request.endereco());


        endereco.setFuncionario(funcionario);

        enderecoRepository.save(endereco);

        return funcionarioMapper.paraResposta(funcionario);
    }

    public FuncionarioResponseDto buscarPorId (Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(FuncionarioNaoExisteException::new);

        return funcionarioMapper.paraResposta(funcionario);
    }
}
