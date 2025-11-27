package com.senai.iniciandojpa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    private final EnderecoService service;
}
