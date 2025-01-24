package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "barcode")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
