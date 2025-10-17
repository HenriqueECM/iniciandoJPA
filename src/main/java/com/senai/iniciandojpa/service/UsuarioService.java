package com.senai.iniciandojpa.service;

import com.senai.iniciandojpa.exception.UsuarioJaExiste;
import com.senai.iniciandojpa.exception.UsuarioNaoExisteException;
import com.senai.iniciandojpa.model.Usuario;
import com.senai.iniciandojpa.repository.UsuarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor // se der erro injeção de @ do construtor, instalar o lombok no plugin do intelliJ
public class UsuarioService {
    private final UsuarioRepositorio repositorio;

    public Usuario create (Usuario usuario){
        if (repositorio.existsByNome(usuario.getNome())){
            throw new UsuarioJaExiste();
        }

        return repositorio.save(usuario);
    }

    public List<Usuario> buscarTodos() {
        return repositorio.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() ->{
                    throw new UsuarioNaoExisteException();
                });
    }

    public Usuario update(Long id, Usuario usuario){
        if (!repositorio.existsById(id)){
            throw new UsuarioNaoExisteException();
        }
        usuario.setId(id);
        return repositorio.save(usuario);
    }

    public void delete(Long id) {
        if (!repositorio.existsById(id)){
            throw new UsuarioNaoExisteException();
        }
        repositorio.deleteById(id);
    }

}
