package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.exercicio2.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByNome(String nome);
}
