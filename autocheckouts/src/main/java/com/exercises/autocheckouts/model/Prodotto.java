package com.exercises.autocheckouts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//import javax.persistence.Entity;
//import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "idprodotto", nullable = false)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "idprodotto")
//    private Long idProdotto;
    @Column(name = "nome")
    private String nome;
    @Column(name = "prezzo")
    private double prezzo;
    @Column(name = "descrizione")
    private String descrizione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Costruttore
    public Prodotto() {}

    public Prodotto(String nome, double prezzo, String descrizione) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }

    // Getter e Setter
//    public Long getIdProdotto() {
//        return idProdotto;
//    }
//
//    public void setIdProdotto(Long idProdotto) {
//        this.idProdotto = idProdotto;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}