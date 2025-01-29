package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.*;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import com.exercises.autocheckouts.repository.ScontrinoRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    public List<Scontrino> findByDate(String data) {
        Calendar calendar;
        if(data.equals("today")){
              calendar = Calendar.getInstance();
        }else{
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date inputDate = sdf.parse(data);
                calendar = Calendar.getInstance();
                calendar.setTime(inputDate);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Non è stato inserito un valore 'data' corretto");
                return new ArrayList<>();
            }
        }
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

    public List<Scontrino> findByYear(int year) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(year + "-01-01");
            Date endDate = sdf.parse(year + "-12-31");
            return scontrinoRepository.findByDataBetween(startDate,endDate);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Non è stato inserito un valore 'anno' corretto");
            return new ArrayList<>();
        }
    }

    // crea una Map che associa ogni nome prodotto a una coppia di valori (lista) quantità - importo
    // Dopo aver estratto tutti gli scontrini del giorno X cicla su ogni barcode contenuto in essi e mappa all'interno della map
    // prodotto per prodotto. Alla fine stampa la mappa, quiondi per ogni prodotto verrà visualizzato
    // la quantità venduta in quel giorno e il ricavo associato (quantità * prezzounitario)
    public Map<String, List<Double>> getDettaglioPerProdotto(List<Scontrino> scontriniGiornoX) {
        Map<String, List<Double>> resultMap = new HashMap<>();
        if(!scontriniGiornoX.isEmpty()){
            for (Scontrino s: scontriniGiornoX) {
                System.out.println("ciao");
                List<Barcode> barcodes = s.getBarcodes();

                for (Barcode b: barcodes) {
                    Prodotto prodotto = prodottoRepository.findByBarcodes(b);
                    List<Double> quantitaPrezzo = new ArrayList<>();
                    Prezzo prezzo = prezzoService.getPrezzoByBarcode(b);
                    if(resultMap.containsKey(prodotto.getNome())){
                        int quantita = (int) (resultMap.get(prodotto.getNome()).get(0) + 1);
                        quantitaPrezzo.add(0, (double) quantita);
                        quantitaPrezzo.add(1, quantita*prezzo.getPrezzo() );
                        resultMap.put(prodotto.getNome(), quantitaPrezzo);
                    }else{
                        quantitaPrezzo.add(0, 1.0 );
                        quantitaPrezzo.add(1, prezzo.getPrezzo() );
                        resultMap.put(prodotto.getNome(), quantitaPrezzo);
                    }
                }
            }

            System.out.println("Il giorno " + scontriniGiornoX.get(0).getData() + " sono stati venduti i seguenti prodotti:");
            resultMap.forEach((product, quantityAndPrice) -> {
                System.out.println(product + " quantità: " + quantityAndPrice.get(0) + " ricavo: "+ quantityAndPrice.get(1));
            });
        }
        return resultMap;
    }
    //stessa cosa del metodo sopra ma suddivide per reparto
    public Map<String, List<Double>> getDettaglioPerReparto(List<Scontrino> scontriniGiornoX) {
        Map<String, List<Double>> products = new HashMap<>();
        if(!scontriniGiornoX.isEmpty()){
            for (Scontrino s: scontriniGiornoX) {
                System.out.println("ciao");
                List<Barcode> barcodes = s.getBarcodes();

                for (Barcode b: barcodes) {
                    Prodotto prodotto = prodottoRepository.findByBarcodes(b);
                    List<Double> quantitaPrezzo = new ArrayList<>();
                    Prezzo prezzo = prezzoService.getPrezzoByBarcode(b);
                    if(products.containsKey(prodotto.getReparto())){
                        int newQuantita = (int) (products.get(prodotto.getReparto()).get(0) + 1);
                        quantitaPrezzo.add(0, (double) newQuantita);
                        quantitaPrezzo.add(1, newQuantita*prezzo.getPrezzo() );
                        products.put(prodotto.getReparto(), quantitaPrezzo);
                    }else{
                        quantitaPrezzo.add(0, 1.0 );
                        quantitaPrezzo.add(1, prezzo.getPrezzo() );
                        products.put(prodotto.getReparto(), quantitaPrezzo);
                    }
                }
            }

            System.out.println("Sono stati venduti i seguenti prodotti:");
            products.forEach((product, quantityAndPrice) -> {
                System.out.println(product + " quantità: " + quantityAndPrice.get(0) + " ricavo: "+ quantityAndPrice.get(1));
            });
        }
        return products;
    }


}
