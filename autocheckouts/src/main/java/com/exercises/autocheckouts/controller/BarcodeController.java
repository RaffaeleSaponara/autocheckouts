package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.model.ProdottoDTO;
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

    @GetMapping("/prodotto/{code}")
    public ResponseEntity<ProdottoDTO> getProdottoByBarcode(@PathVariable String code) {
        Barcode barcode = barcodeService.getBarcodeByCode(code);
        Prodotto prodotto = barcodeService.getProdottoByBarcode(barcode);
        ProdottoDTO prodottoDTO = ProdottoDTO.convertToDTO(prodotto);
        return ResponseEntity.ok(prodottoDTO);
    }

}
