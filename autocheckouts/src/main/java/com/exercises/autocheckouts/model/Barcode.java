package com.exercises.autocheckouts.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "barcode")
public class Barcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbarcode")
    private Long id;
    @Column(name = "inizio")
    private Date inizio;
    @Column(name = "fine")
    private Date fine;
    @Column(name = "code")
    private String code;

    public Barcode(){}

    public Barcode(Date inizio, Date fine, String barcode){
        this.inizio = inizio;
        this.fine = fine;
        this.code = barcode;
    }

    protected Date getInizio() {
        return inizio;
    }

    protected void setInizio(Date inizio) {
        this.inizio = inizio;
    }

    protected Date getFine() {
        return fine;
    }

    protected void setFine(Date fine) {
        this.fine = fine;
    }

    protected String getcode() {
        return code;
    }

    protected void setBarcode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
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
