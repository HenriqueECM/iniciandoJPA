package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByNome(String nome);
}
