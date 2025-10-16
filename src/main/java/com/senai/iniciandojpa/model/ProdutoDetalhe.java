package com.senai.iniciandojpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "produto_detalhe")
public class ProdutoDetalhe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private double peso;

    @Column(nullable = false, length = 50)
    private String fabricante;
}
