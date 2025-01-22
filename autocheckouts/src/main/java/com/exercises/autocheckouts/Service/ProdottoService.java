package com.exercises.autocheckouts.Service;

import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {
    @Autowired
    ProdottoRepository prodottoRepository;


    public ProdottoService() {
        System.out.println("creo un oggetto OrderService...");
    }

    // Aggiungere un prodotto al database
    public Prodotto aggiungiProdotto(Prodotto prodotto) {
        return prodottoRepository.save(prodotto);
    }

    // Ottenere tutti i prodotti
    public List<Prodotto> getTuttiIProdotti() {
        return prodottoRepository.findAll();
    }

    // Ottenere un prodotto per ID
    public Optional<Prodotto> getProdottoPerId(Long id) {
        return prodottoRepository.findById(id);
    }

    // Aggiornare un prodotto
    public Prodotto aggiornaProdotto(Long id, Prodotto nuovoProdotto) {
        // Verifica se il prodotto esiste
        Optional<Prodotto> prodottoEsistente = prodottoRepository.findById(id);
        if (prodottoEsistente.isPresent()) {
            Prodotto prodotto = prodottoEsistente.get();
            prodotto.setNome(nuovoProdotto.getNome());
            prodotto.setPrezzo(nuovoProdotto.getPrezzo());
            prodotto.setDescrizione(nuovoProdotto.getDescrizione());
            return prodottoRepository.save(prodotto);
        }
        return null;  // Se non esiste, ritorna null
    }

    // Eliminare un prodotto
    public boolean eliminaProdotto(Long id) {
        if (prodottoRepository.existsById(id)) {
            prodottoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}