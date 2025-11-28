package com.senai.iniciandojpa.model.exercicio1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @OneToOne(mappedBy = "documento")
    private Pessoa pessoa;

    public Documento(Long numero, TipoDocumento tipo) {
        this.numero = numero;
        this.tipoDocumento = tipo;
    }
}
