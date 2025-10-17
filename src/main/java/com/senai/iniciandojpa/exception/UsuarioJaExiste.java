package com.senai.iniciandojpa.exception;

public class UsuarioJaExiste extends RuntimeException{
    public UsuarioJaExiste(){
        super("O usuario ja existe");
    }
}
