package com.senai.iniciandojpa.exception;

public class AlunoNaoExisteException extends RuntimeException {
    public AlunoNaoExisteException () {
        super("Aluno não encontrado.");
    }
}
