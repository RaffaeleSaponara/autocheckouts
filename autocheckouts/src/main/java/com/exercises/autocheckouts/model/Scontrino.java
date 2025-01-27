package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "scontrino")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
            name = "barcode_scontrino",
            joinColumns = @JoinColumn(name = "idscontrino"),
            inverseJoinColumns = @JoinColumn(name = "idbarcode")
    )
    private List<Barcode> barcodes;



}
