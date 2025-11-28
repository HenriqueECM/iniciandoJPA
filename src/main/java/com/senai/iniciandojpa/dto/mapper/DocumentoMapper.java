package com.senai.iniciandojpa.dto.mapper;

import com.senai.iniciandojpa.dto.request.DocumentoRequestDto;
import com.senai.iniciandojpa.dto.response.DocumentoResponseDto;
import com.senai.iniciandojpa.model.exercicio1.Documento;
import org.springframework.stereotype.Component;

@Component
public class DocumentoMapper {
    public Documento paraEntidade (DocumentoRequestDto request){
        Documento documento = new Documento();

        documento.setNumero(request.numero());
        documento.setTipoDocumento(request.tipo());

        return documento;
    }

    public DocumentoResponseDto paraResposta (Documento documento){
        return new DocumentoResponseDto(
                documento.getId(),
                documento.getNumero(),
                documento.getTipoDocumento()
        );
    }
}
