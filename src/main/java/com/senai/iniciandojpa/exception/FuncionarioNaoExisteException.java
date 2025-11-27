package com.senai.iniciandojpa.exception;

public class FuncionarioNaoExisteException extends RuntimeException {
    public FuncionarioNaoExisteException () {
        super("Funcionário não encontrado no sistema.");
    }
}
