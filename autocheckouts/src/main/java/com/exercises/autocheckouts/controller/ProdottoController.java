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
    @Autowired
    private final ProdottoService prodottoService;


    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService=prodottoService;
    }

    // Metodo per ottenere tutti i prodotti
    @GetMapping
    public List<Prodotto> getAllProdotti() {
        return prodottoService.getTuttiIProdotti();
    }

    // Metodo per ottenere un prodotto per ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getProdottoById(@PathVariable Long id, Model model) {
        Prodotto a = prodottoService.getProdottoPerId(id).orElse(null);
        System.out.println(a.getNome());
        return ResponseEntity.ok("Hello World!" + a.toString());
    }

    // Metodo per aggiungere un prodotto
    @PostMapping
    public Prodotto aggiungiProdotto(@RequestBody Prodotto prodotto) {
        return prodottoService.aggiungiProdotto(prodotto);
    }

    // Metodo per aggiornare un prodotto
    @PutMapping("/{id}")
    public Prodotto aggiornaProdotto(@PathVariable Long id, @RequestBody Prodotto nuovoProdotto) {
        return prodottoService.aggiornaProdotto(id, nuovoProdotto);
    }

    // Metodo per eliminare un prodotto
    @DeleteMapping("/{id}")
    public String eliminaProdotto(@PathVariable Long id) {
        boolean success = prodottoService.eliminaProdotto(id);
        return success ? "Prodotto eliminato con successo!" : "Prodotto non trovato!";
    }
}