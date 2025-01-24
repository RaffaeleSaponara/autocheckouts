package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.model.Unit;
import com.exercises.autocheckouts.service.ScontrinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/scontrino")
public class ScontrinoController {

    private final ScontrinoService scontrinoService;

    public ScontrinoController(ScontrinoService scontrinoService) {
        this.scontrinoService = scontrinoService;
    }



    @PostMapping("/creaScontrino")
    public ResponseEntity<Scontrino> creaScontrino(@RequestBody List<Prodotto> dettaglio) {
        Scontrino scontrino = scontrinoService.aggiungiScontrino(dettaglio);
        return ResponseEntity.ok(scontrino);
    }
}
