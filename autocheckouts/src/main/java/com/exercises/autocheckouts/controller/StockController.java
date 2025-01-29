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

    public StockController(StockService stockService, ScontrinoService scontrinoService) {
        this.stockService=stockService;
        this.scontrinoService=scontrinoService;
    }

    @GetMapping("/aggiorna")
    public ResponseEntity<String> aggiornaStock(){
        List<Scontrino> scontriniToday = scontrinoService.findByDate("today");
        stockService.aggiornaStock(scontriniToday);
        return ResponseEntity.ok("Stock Aggiornati!");
    }
}
