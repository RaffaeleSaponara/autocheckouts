package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.service.BarcodeService;
import com.exercises.autocheckouts.service.ProdottoService;
import com.exercises.autocheckouts.service.ScontrinoService;
import com.exercises.autocheckouts.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;
    private final ScontrinoService scontrinoService;
    private final BarcodeService barcodeService;
    private final ProdottoService prodottoService;

    public StockController(StockService stockService, ScontrinoService scontrinoService, BarcodeService barcodeService, ProdottoService prodottoService) {
        this.stockService=stockService;
        this.scontrinoService=scontrinoService;
        this.barcodeService=barcodeService;
        this.prodottoService=prodottoService;
    }

    @GetMapping("/aggiorna")
    public ResponseEntity<String> aggiornaStock(){

        List<Scontrino> scontriniToday = scontrinoService.findByTodayDate();
        stockService.aggiornaStock(scontriniToday);
        return ResponseEntity.ok("Stock Aggiornati!");
    }
}
