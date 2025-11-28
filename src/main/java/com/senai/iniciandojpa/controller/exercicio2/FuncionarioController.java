package com.senai.iniciandojpa.controller.exercicio2;

import com.senai.iniciandojpa.dto.request.FuncionarioRequestDto;
import com.senai.iniciandojpa.dto.response.FuncionarioResponseDto;
import com.senai.iniciandojpa.service.exercicio2.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> criar (@RequestBody FuncionarioRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarFuncionario(request));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<FuncionarioResponseDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }
}
