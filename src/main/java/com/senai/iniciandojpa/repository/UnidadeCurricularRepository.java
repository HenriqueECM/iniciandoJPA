package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.exercicioExtra.UnidadeCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeCurricularRepository extends JpaRepository<UnidadeCurricular, Long> {
    boolean existsByNome(String nome);
}
