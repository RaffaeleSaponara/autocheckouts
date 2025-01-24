package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Prezzo;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.repository.PrezzoRepository;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrezzoService {
    private final PrezzoRepository prezzoRepository;

    @Autowired
    public PrezzoService(PrezzoRepository prezzoRepository) {
        this.prezzoRepository = prezzoRepository;
    }

    public Double calculatePrezzo(List<Prodotto> prodotti) {

        Double tot = 0.0;

        for(Prodotto p : prodotti){
            Optional<Prezzo> prezzo = prezzoRepository.findByProdotto(p);
            if(prezzo.isPresent()) {
               tot += prezzo.get().getPrezzo();
            }
        }


       return tot;
    }
}
