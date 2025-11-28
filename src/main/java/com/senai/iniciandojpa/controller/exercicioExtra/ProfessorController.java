package com.senai.iniciandojpa.controller.exercicioExtra;

import com.senai.iniciandojpa.dto.request.ProfessorRequestDto;
import com.senai.iniciandojpa.dto.response.ProfessorResponseDto;
import com.senai.iniciandojpa.service.exercicioExtra.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professor")
@AllArgsConstructor
public class ProfessorController {
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> criar (@RequestBody ProfessorRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProfessorResponseDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping("/{professorId}/cadastrar/{curricularId}")
    public ResponseEntity<ProfessorResponseDto> cadastrarProfessorComUc (@PathVariable Long professorId, @PathVariable Long curricularId){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarProfessorUc(professorId, curricularId));
    }
}
