package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.repository.ScontrinoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScontrinoService {
    private final ScontrinoRepository scontrinoRepository;
    private final PrezzoService prezzoService;

    public ScontrinoService(ScontrinoRepository scontrinoRepository, PrezzoService prezzoService) {
        this.scontrinoRepository = scontrinoRepository;
        this.prezzoService = prezzoService;
    }

    public Scontrino aggiungiScontrino(List<Barcode> dettaglio) {
        Double tot = prezzoService.calculatePrezzoByBarcode(dettaglio);
        Scontrino scontrino = new Scontrino(null, tot, new Date(), dettaglio);
        return scontrinoRepository.save(scontrino);
    }

}
