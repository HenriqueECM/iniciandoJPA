package com.senai.iniciandojpa.controller.exercicioExtra;

import com.senai.iniciandojpa.dto.request.UnidadeCurricularRequestDto;
import com.senai.iniciandojpa.dto.response.UnidadeCurricularResponseDto;
import com.senai.iniciandojpa.service.exercicioExtra.UnidadeCurricularService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/uc")
public class UnidadeCurricularController {
    private final UnidadeCurricularService service;

    @PostMapping
    public ResponseEntity<UnidadeCurricularResponseDto> criar (@RequestBody UnidadeCurricularRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<UnidadeCurricularResponseDto>> buscarTodos (){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UnidadeCurricularResponseDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }
}
