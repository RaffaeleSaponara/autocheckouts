package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import com.exercises.autocheckouts.repository.ScontrinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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


    public Scontrino aggiungiScontrino(List<Prodotto> dettaglio) {

        Double tot = prezzoService.calculatePrezzo(dettaglio);

        Scontrino scontrino = new Scontrino(tot, new Date(), dettaglio);

        return scontrinoRepository.save(scontrino);
    }


}
