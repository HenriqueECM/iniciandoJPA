package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.exercicioExtra.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    boolean existsByNome(String nome);
}
