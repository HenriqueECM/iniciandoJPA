package com.senai.iniciandojpa.controller.exercicio3;

import com.senai.iniciandojpa.dto.request.CursoRequestDto;
import com.senai.iniciandojpa.dto.response.CursoResponseDto;
import com.senai.iniciandojpa.service.exercicio3.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/curso")
public class CursoController {
    private final CursoService service;

    @PostMapping
    public ResponseEntity<CursoResponseDto> criar (@RequestBody CursoRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CursoResponseDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }
}
