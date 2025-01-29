package com.exercises.autocheckouts.controller;
;
import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.service.ProdottoService;
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



}