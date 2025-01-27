package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "prodotto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "reparto")
    private String reparto;
    @Column(name = "grammatura")
    private int grammatura;
    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private Unit unit;

    @OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Barcode> barcodes;

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", unit=" + unit +
                ", reparto='" + reparto + '\'' +
                '}';
    }
}