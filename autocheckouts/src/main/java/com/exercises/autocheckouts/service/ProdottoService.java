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

    @Autowired
    public ProdottoService(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }
    public Prodotto aggiungiProdotto(Prodotto prodotto) {
        return prodottoRepository.save(prodotto);
    }
    public List<Prodotto> getTuttiIProdotti() {
        return prodottoRepository.findAll();
    }
    public Optional<Prodotto> getProdottoPerId(Long id) {
        return prodottoRepository.findById(id);
    }
    public Prodotto aggiornaProdotto(Long id, Prodotto nuovoProdotto) {
        Optional<Prodotto> prodottoEsistente = prodottoRepository.findById(id);
        if (prodottoEsistente.isPresent()) {
            Prodotto prodotto = prodottoEsistente.get();
            prodotto.setNome(nuovoProdotto.getNome());
            prodotto.setGrammatura(nuovoProdotto.getGrammatura());
            prodotto.setReparto(nuovoProdotto.getReparto());
            return prodottoRepository.save(prodotto);
        }
        return null;
    }

    public boolean eliminaProdotto(Long id) {
        if (prodottoRepository.existsById(id)) {
            prodottoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}