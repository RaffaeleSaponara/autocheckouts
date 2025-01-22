package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.repository.BarcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarcodeService {

    private final BarcodeRepository barcodeRepository;

    @Autowired
    public BarcodeService(BarcodeRepository barcodeRepository) {
        this.barcodeRepository = barcodeRepository;
    }

    public Optional<Barcode> getBarcodePerId(Long id) {
        return barcodeRepository.findById(id);
    }

}
