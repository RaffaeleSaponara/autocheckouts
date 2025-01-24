package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "barcode")
@Data
public class Barcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "inizio")
    private Date inizio;
    @Column(name = "fine")
    private Date fine;
    @Column(name = "code")
    private String code;
    @ManyToOne
    @JoinColumn(name = "idprodotto")
    private Prodotto prodotto;

    public Barcode(){}

    public Barcode(Date inizio, Date fine, String barcode){
        this.inizio = inizio;
        this.fine = fine;
        this.code = barcode;
    }



    @Override
    public String toString() {
        return "Barcode{" +
                "id=" + id +
                ", inizio='" + inizio + '\'' +
                ", fine=" + fine +
                ", code=" + code +
                '}';
    }


}
