package com.senai.iniciandojpa.repository;

import com.senai.iniciandojpa.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
