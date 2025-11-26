package com.senai.iniciandojpa.exception;

public class PessoaJaExisteException extends RuntimeException {
    public PessoaJaExisteException (){
        super("Pessoa já existe no sistema.");
    }
}
