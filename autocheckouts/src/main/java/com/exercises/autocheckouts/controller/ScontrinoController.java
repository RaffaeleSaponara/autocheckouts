package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.model.ScontrinoDTO;
import com.exercises.autocheckouts.service.BarcodeService;
import com.exercises.autocheckouts.service.ScontrinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/scontrino")
public class ScontrinoController {

    private final ScontrinoService scontrinoService;
    private final BarcodeService barcodeService;

    public ScontrinoController(ScontrinoService scontrinoService, BarcodeService barcodeService) {
        this.scontrinoService = scontrinoService;
        this.barcodeService = barcodeService;
    }

    @PostMapping("/creaScontrino")
    public ResponseEntity<ScontrinoDTO> creaScontrino(@RequestBody String[] dettaglio) {
        List<Barcode> listaBarcode = barcodeService.getBarcodesByCodes(dettaglio);
        Scontrino scontrino = scontrinoService.aggiungiScontrino(listaBarcode);
        ScontrinoDTO scontrinoDTO = ScontrinoDTO.convertToDTO(scontrino);
        return ResponseEntity.ok(scontrinoDTO);
    }

    @GetMapping("/incasso")
    public ResponseEntity<Double> getIncassoGiornata(){
        double incasso= 0.0;
        List<Scontrino> scontriniToday = scontrinoService.findByTodayDate();
        for (Scontrino s: scontriniToday) {
            incasso += s.getImporto();
        }
        return ResponseEntity.ok(incasso);
    }


}
