package com.senai.iniciandojpa.exception;

public class PessoaNaoExisteException extends RuntimeException {
    public PessoaNaoExisteException () {
        super("Pessoa não encontrada.");
    }
}
