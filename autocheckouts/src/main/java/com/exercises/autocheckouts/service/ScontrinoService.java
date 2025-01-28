package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.*;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import com.exercises.autocheckouts.repository.ScontrinoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScontrinoService {
    private final ScontrinoRepository scontrinoRepository;
    private final PrezzoService prezzoService;
    private final ProdottoRepository prodottoRepository;

    public ScontrinoService(ScontrinoRepository scontrinoRepository, PrezzoService prezzoService, ProdottoRepository prodottoRepository) {
        this.scontrinoRepository = scontrinoRepository;
        this.prezzoService = prezzoService;
        this.prodottoRepository=prodottoRepository;
    }

    public Scontrino aggiungiScontrino(List<Barcode> dettaglio) {
        Double tot = prezzoService.calculatePrezzoByBarcode(dettaglio);
        Scontrino scontrino = new Scontrino(null, tot, new Date(), dettaglio);
        return scontrinoRepository.save(scontrino);
    }

    public List<Scontrino> findByTodayDate() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startOfDay = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date endOfDay = calendar.getTime();

        List<Scontrino> scontrini = scontrinoRepository.findByDataBetween(startOfDay, endOfDay);
        return scontrini;
    }

    public List<Scontrino> findByDate(Long data) {
        // ho settato una data di prova per fare dei test, altrimenti la prende come param in input
        long currentTimeMillis = System.currentTimeMillis();
        long oneDayInMillis = 24 * 60 * 60 * 1000;
        long yesterdayMillis = currentTimeMillis - oneDayInMillis;
        Date d = new Date(yesterdayMillis);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startOfDay = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date endOfDay = calendar.getTime();
        return scontrinoRepository.findByDataBetween(startOfDay, endOfDay);
    }

    // crea una Map che associa ogni nome prodotto a una coppia di valori (lista) quantità - importo
    // Dopo aver estratto tutti gli scontrini cicla su ogni barcode contenuto in essi e mappa all'interno della map
    // prodotto per prodotto. Alla fine stampa la mappa, quiondi per ogni prodotto verrà visualizzato
    // la quantità venduta in quel giorno e il ricavo associato (quantità * prezzo)
    public Map<String, List<Double>> getDettaglio(List<Scontrino> scontriniGiornoX) {
        Map<String, List<Double>> products = new HashMap<>();
        if(!scontriniGiornoX.isEmpty()){
            for (Scontrino s: scontriniGiornoX) {
                System.out.println("ciao");
                List<Barcode> barcodes = s.getBarcodes();

                for (Barcode b: barcodes) {
                    Prodotto prodotto = prodottoRepository.findByBarcodes(b);
                    List<Double> quantitaPrezzo = new ArrayList<>();
                    Prezzo prezzo = prezzoService.getPrezzoByBarcode(b);
                    if(products.containsKey(prodotto.getNome())){
                        int quantita = (int) (products.get(prodotto.getNome()).get(0) + 1);
                        quantitaPrezzo.add(0, (double) quantita);
                        quantitaPrezzo.add(1, quantita*prezzo.getPrezzo() );
                        products.put(prodotto.getNome(), quantitaPrezzo);
                    }else{
                        quantitaPrezzo.add(0, 1.0 );
                        quantitaPrezzo.add(1, prezzo.getPrezzo() );
                        products.put(prodotto.getNome(), quantitaPrezzo);
                    }
                }
            }


            System.out.println("Il giorno " + scontriniGiornoX.get(0).getData() + " sono stati venduti i seguenti prodotti:");

            products.forEach((product, quantityAndPrice) -> {

                System.out.println(product + " quantità: " + quantityAndPrice.get(0) + " ricavo: "+ quantityAndPrice.get(1));

            });
        }
        return products;
    }
}
