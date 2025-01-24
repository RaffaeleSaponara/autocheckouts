package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "stock")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantita")
    private int quantita;
    @Column(name = "data")
    private Date data;
    @ManyToOne
    @JoinColumn(name = "idprodotto")
    private Prodotto prodotto;

    public Stock(){};

    public Stock(int quantita, Date data){
        this.quantita=quantita;
        this.data=data;
    }


}
