package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "prezzo")
@Data
public class Prezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "prezzo")
    private Double prezzo;
    @Column(name = "data")
    private Date data;
    @ManyToOne
    @JoinColumn(name = "idprodotto")
    private Prodotto prodotto;

    public Prezzo(){};

    public Prezzo(double prezzo, Date data){
        this.prezzo=prezzo;
        this.data=data;
    }


}
