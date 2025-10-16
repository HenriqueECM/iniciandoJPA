package com.senai.iniciandojpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "avaliacao_produto")
public class AvaliacaoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 3, scale = 2, nullable = false)
    private double nota;

    @Lob
    private String comentario;

    @Temporal(TemporalType.DATE)
    private LocalDate dataAvaliacao;
}
