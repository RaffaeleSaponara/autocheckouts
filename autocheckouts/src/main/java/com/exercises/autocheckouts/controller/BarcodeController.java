package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/barcode")
public class BarcodeController {
    @Autowired
    private final BarcodeService barcodeService;

    public BarcodeController(BarcodeService barcodeService) {
        this.barcodeService=barcodeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProdottoById(@PathVariable Long id, Model model) {
        Barcode a = barcodeService.getBarcodePerId(id).orElse(null);
        return ResponseEntity.ok("Hello World!" + a.toString());
    }

    @GetMapping("/prodotto/{code}")
    public ResponseEntity<Prodotto> getProdottoByBarcode(@PathVariable String code) {
        Barcode barcode = barcodeService.getBarcodeByCode(code);
        Prodotto prodotto = barcodeService.getProdottoByBarcode(barcode);
        return ResponseEntity.ok(prodotto);
    }

}
