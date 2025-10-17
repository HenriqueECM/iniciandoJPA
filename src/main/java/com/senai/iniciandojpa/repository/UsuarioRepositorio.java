package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    boolean existeByNome (String nome);
}
