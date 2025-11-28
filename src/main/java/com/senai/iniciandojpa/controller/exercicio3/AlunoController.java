package com.senai.iniciandojpa.controller.exercicio3;

import com.senai.iniciandojpa.dto.request.AlunoRequestDto;
import com.senai.iniciandojpa.dto.response.AlunoResponseDto;
import com.senai.iniciandojpa.service.exercicio3.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    private AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoResponseDto> criar (@RequestBody AlunoRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarAluno(request));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<AlunoResponseDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping("/{alunoId}/matricular/{cursoId}")
    public ResponseEntity<AlunoResponseDto> matricular (@PathVariable Long alunoId, @PathVariable Long cursoId){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.matricular(alunoId, cursoId));
    }
}
