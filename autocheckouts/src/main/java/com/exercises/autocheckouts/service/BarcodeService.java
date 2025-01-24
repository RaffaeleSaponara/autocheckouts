package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.repository.BarcodeRepository;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarcodeService {

    private final BarcodeRepository barcodeRepository;
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public BarcodeService(BarcodeRepository barcodeRepository, ProdottoRepository prodottoRepository) {
        this.barcodeRepository = barcodeRepository;
        this.prodottoRepository = prodottoRepository;
    }

    public Optional<Barcode> getBarcodePerId(Long id) {
        return barcodeRepository.findById(id);
    }

//    public Optional<Prodotto> getProdottoByBarcode(String code) {
//        Optional<Prodotto> prodotto = barcodeRepository.findByCode(code);
//        return prodotto;
//    }

    public Barcode getBarcodeByCode(String code) {
        Barcode barcode = barcodeRepository.findByCode(code);
        return  barcode;
    }

    public Prodotto getProdottoByBarcode(Barcode barcode) {
        Prodotto prodotto = prodottoRepository.findByBarcode(barcode);
        return prodotto;
    }
}
