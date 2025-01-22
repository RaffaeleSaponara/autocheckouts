package com.exercises.autocheckouts.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodotto")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "reparto")
    private String reparto;
    @Column(name = "prezzo")
    private double prezzo;
    @Column(name = "grammatura")
    private int grammatura;
    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private Unit unit;
    @Column(name = "stock")
    private int stock;



    // Costruttore
    public Prodotto() {}

    public Prodotto(String nome, int grammatura, String reparto, double prezzo, Unit unit, int stock) {
        this.nome = nome;
        this.grammatura = grammatura;
        this.reparto = reparto;
        this.prezzo = prezzo;
        this.unit = unit;
        this.stock = stock;

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
    public double getPrezzo() {return prezzo;}
    public void setPrezzo(double prezzo) {this.prezzo = prezzo;}
    public Unit getUnit() {return unit;}
    public void setUnit(Unit unit) {this.unit = unit;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prezzo=" + grammatura +
                ", unit=" + unit +
                ", stock=" + stock +
                ", reparto='" + reparto + '\'' +
                '}';
    }
}