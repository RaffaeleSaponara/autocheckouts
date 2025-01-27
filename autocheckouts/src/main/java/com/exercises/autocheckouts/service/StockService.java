package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.model.Stock;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import com.exercises.autocheckouts.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public StockService(StockRepository stockRepository,
                        ProdottoRepository prodottoRepository) {
        this.stockRepository = stockRepository;
        this.prodottoRepository = prodottoRepository;
    }


    public Integer findQuantitaByLastDate(Prodotto prodotto) {
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

        Stock stock = stockRepository.findByProdottoAndDataBetween(prodotto,startOfDay, endOfDay);
        return stock.getQuantita();
    }

    public Stock save(Prodotto prodotto, int i) {
        Stock newStock = new Stock(null, i, new Date(), prodotto);
        return stockRepository.save(newStock);
    }


    public void aggiornaStock(List<Scontrino> scontriniToday) {
        Map<String, Integer> products = new HashMap<>();
        for (Scontrino s: scontriniToday) {
            System.out.println("ciao");
            List<Barcode> barcodes = s.getBarcodes();

            for (Barcode b: barcodes) {
                Prodotto prodotto = prodottoRepository.findByBarcodes(b);

                if(products.containsKey(prodotto.getNome())){
                    products.put(prodotto.getNome(), products.get(prodotto.getNome()) + 1);
                }else{
                    products.put(prodotto.getNome(), 1);
                }
            }
        }

        products.forEach((product, quantity) -> {
            Prodotto prodotto = prodottoRepository.findByNome(product);
            Integer lastStock = findQuantitaByLastDate(prodotto);
            Stock newStock = new Stock(null, lastStock-quantity, new Date(), prodotto);
            stockRepository.save(newStock);
        });

    }
}
