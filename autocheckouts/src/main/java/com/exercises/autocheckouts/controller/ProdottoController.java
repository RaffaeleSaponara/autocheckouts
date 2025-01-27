package com.exercises.autocheckouts.controller;
;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prodotto")
public class ProdottoController {

    private final ProdottoService prodottoService;

    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService=prodottoService;
    }

    @GetMapping
    public String getAllProdotti(Model model) {
        List<Prodotto> prodotti =prodottoService.getTuttiIProdotti();
        model.addAttribute("prodotti",prodotti);
        return "scontrino";
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Prodotto> getProdottoById(@PathVariable Long id, Model model) {
//        Prodotto a = prodottoService.getProdottoPerId(id).orElse(null);
//        return ResponseEntity.ok(a);
//    }


}