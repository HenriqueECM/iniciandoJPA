package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByNome(String nome);
}
