package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Barcode;
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

    public PrezzoService(PrezzoRepository prezzoRepository) {
        this.prezzoRepository = prezzoRepository;
    }

    public Double calculatePrezzoByBarcode(List<Barcode> prodotti) {

        Double tot = 0.0;

        for(Barcode b : prodotti){
            Optional<Prezzo> prezzo = prezzoRepository.findByBarcode(b);
            if(prezzo.isPresent()) {
               tot += prezzo.get().getPrezzo();
            }
        }
       return tot;
    }

    public Prezzo getPrezzoByBarcode(Barcode barcode){
        return prezzoRepository.findPrezzoByBarcode(barcode);
    }
}
