package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {

    private final ProdottoRepository prodottoRepository;

    public ProdottoService(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public List<Prodotto> getTuttiIProdotti() {
        return prodottoRepository.findAll();
    }


}