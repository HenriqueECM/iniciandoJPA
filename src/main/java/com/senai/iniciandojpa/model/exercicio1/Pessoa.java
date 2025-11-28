package com.senai.iniciandojpa.model.exercicio1;

import com.senai.iniciandojpa.model.exercicio1.Documento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToOne (cascade = CascadeType.ALL)
    private Documento documento;
}
