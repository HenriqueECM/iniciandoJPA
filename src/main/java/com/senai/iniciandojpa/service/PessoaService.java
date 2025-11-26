package com.senai.iniciandojpa.service;

import com.senai.iniciandojpa.dto.mapper.DocumentoMapper;
import com.senai.iniciandojpa.dto.mapper.PessoaMapper;
import com.senai.iniciandojpa.dto.request.PessoaRequestDto;
import com.senai.iniciandojpa.dto.response.PessoaResponseDto;
import com.senai.iniciandojpa.exception.PessoaJaExisteException;
import com.senai.iniciandojpa.exception.PessoaNaoExisteException;
import com.senai.iniciandojpa.model.Documento;
import com.senai.iniciandojpa.model.Pessoa;
import com.senai.iniciandojpa.repository.DocumentoRepository;
import com.senai.iniciandojpa.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PessoaService {
    private final PessoaMapper mapper;
    private final PessoaRepository repository;
    private final DocumentoMapper documentoMapper;
    private final DocumentoRepository documentoRepository;

    public PessoaResponseDto criar (PessoaRequestDto request) {
        if (documentoRepository.existsByNumero(request.documento().numero())){
            throw new RuntimeException("Documento ja existe.");
        }

        if(repository.existsByNome(request.nome())){
            throw new PessoaJaExisteException();
        }

        Documento documento = documentoRepository.save(documentoMapper.paraEntidade(request.documento()));
        Pessoa pessoa = mapper.paraEntidade(request);

        pessoa.setDocumento(documento);

        return mapper.paraResposta(repository.save(pessoa));
    }

    public PessoaResponseDto buscarPorId(Long id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(PessoaNaoExisteException::new);

        return mapper.paraResposta(pessoa);
    }
}
