package com.exercises.autocheckouts.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "scontrino")
public class Scontrino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "importo")
    private double importo;
    @Column(name = "data")
    private Date data;
    @ManyToMany
    @JoinTable(
            name = "prodotto_scontrino",
            joinColumns = @JoinColumn(name = "id_scontrino"),
            inverseJoinColumns = @JoinColumn(name = "id_prodotto")
    )
    private List<Prodotto> prodotti;

    public Scontrino(){}

    public Scontrino(double importo, Date data){
        this.setImporto(importo);
        this.setData(data);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }
}
