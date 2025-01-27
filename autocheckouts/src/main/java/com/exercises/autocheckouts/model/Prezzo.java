package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "prezzo")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "idbarcode")
    private Barcode barcode;


}
