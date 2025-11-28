package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.exercicio3.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByNome(String nome);
}
