package com.senai.iniciandojpa.service;

import com.senai.iniciandojpa.dto.mapper.DocumentoMapper;
import com.senai.iniciandojpa.repository.DocumentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentoService {
    private final DocumentoRepository repository;
    private final DocumentoMapper mapper;

//    public void criarDocumento (DocumentoRequestDto request){
//        if (repository.existsByNumero(request.numero())){
//            throw new RuntimeException("Documento já existe no sistema.");
//        }
//
//        mapper.paraResposta(repository.save(mapper.paraEntidade(request)));
//    }
}
