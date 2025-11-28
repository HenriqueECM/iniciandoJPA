package com.senai.iniciandojpa.model.exercicioExtra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    @JoinTable (
            name = "professor_uc",
            joinColumns = @JoinColumn (name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "uc_id")
    )
    private List<UnidadeCurricular> unidadeCurriculares = new ArrayList<>();
}
