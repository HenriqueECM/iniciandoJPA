package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.exercicio2.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
