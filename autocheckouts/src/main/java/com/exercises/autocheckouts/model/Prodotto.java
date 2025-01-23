package com.exercises.autocheckouts.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "prodotto")
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

    public Long getId() {return id;}
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGrammatura() {
        return grammatura;
    }

    public void setGrammatura(int grammatura) {
        this.grammatura = grammatura;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }
    public Unit getUnit() {return unit;}
    public void setUnit(Unit unit) {this.unit = unit;}


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