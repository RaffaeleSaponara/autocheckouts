package com.exercises.autocheckouts.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstock")
    private Long id;
    @Column(name = "quantita")
    private int quantita;
    @Column(name = "data")
    private Date data;

    public Stock(){};

    public Stock(int quantita, Date data){
        this.quantita=quantita;
        this.data=data;
    }
}
