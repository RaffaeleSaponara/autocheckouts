package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "scontrino")
@Data
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

    public Scontrino(double importo, Date data, List<Prodotto> dettaglio){
        this.setImporto(importo);
        this.setData(data);
        this.prodotti=dettaglio;
    }


}
