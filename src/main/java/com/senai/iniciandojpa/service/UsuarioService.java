package com.senai.iniciandojpa.service;

import com.senai.iniciandojpa.exception.UsuarioJaExiste;
import com.senai.iniciandojpa.model.Usuario;
import com.senai.iniciandojpa.repository.UsuarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor // se der erro injeção de @ do construtor, instalar o lombok no plugin do intelliJ
public class UsuarioService {
    private final UsuarioRepositorio repositorio;

    public Usuario create (Usuario usuario){
        if (repositorio.existeByNome(usuario.getNome())){
            throw new UsuarioJaExiste();
        }

        return repositorio.save(usuario);
    }
}
