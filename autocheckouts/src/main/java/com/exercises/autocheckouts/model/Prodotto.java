package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "prodotto")
@Data
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "reparto")
    private String reparto;
    @Column(name = "grammatura")
    private int grammatura;
    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private Unit unit;
    @ManyToMany(mappedBy = "prodotti")
    private List<Scontrino> scontrini;



    // Costruttore
    public Prodotto() {}

    public Prodotto(String nome, int grammatura, String reparto, Unit unit) {
        this.nome = nome;
        this.grammatura = grammatura;
        this.reparto = reparto;
        this.unit = unit;


    }



    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", unit=" + unit +
                ", reparto='" + reparto + '\'' +
                '}';
    }
}