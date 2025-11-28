package com.senai.iniciandojpa.controller.exercicio1;

import com.senai.iniciandojpa.dto.request.PessoaRequestDto;
import com.senai.iniciandojpa.dto.response.PessoaResponseDto;
import com.senai.iniciandojpa.service.exercicio1.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    private final PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaResponseDto> criar (@RequestBody @Valid PessoaRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PessoaResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }
}
