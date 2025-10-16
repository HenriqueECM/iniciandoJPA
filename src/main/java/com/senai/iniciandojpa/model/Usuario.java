package com.senai.iniciandojpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o banco de dados vai auto-incrementar
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @Column(unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true)
    private String senha;
}
