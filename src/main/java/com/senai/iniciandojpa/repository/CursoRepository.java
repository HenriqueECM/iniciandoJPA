package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.exercicio3.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByNome(String nome);
}
