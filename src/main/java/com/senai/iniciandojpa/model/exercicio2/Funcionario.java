package com.senai.iniciandojpa.model.exercicio2;

import com.senai.iniciandojpa.model.exercicio2.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToOne(mappedBy = "funcionario")
    private Endereco endereco;
}
