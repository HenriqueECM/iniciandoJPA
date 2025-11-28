package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.exercicio1.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    boolean existsByNumero(Long numero);
}
