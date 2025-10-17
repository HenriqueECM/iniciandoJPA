package com.senai.iniciandojpa.exception;

public class UsuarioNaoExisteException extends RuntimeException {
    public UsuarioNaoExisteException(){
        super("Usuário não encontrado");
    }
}
