package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    private final ProdottoRepository prodottoRepository;

    public ProdottoService(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public List<Prodotto> getTuttiIProdotti() {
        return prodottoRepository.findAll();
    }
    public Optional<Prodotto> getProdottoPerId(Long id) {
        return prodottoRepository.findById(id);
    }


}