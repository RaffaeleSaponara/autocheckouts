package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.model.ScontrinoDTO;
import com.exercises.autocheckouts.service.BarcodeService;
import com.exercises.autocheckouts.service.ScontrinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/incasso/giornata")
    public ResponseEntity<Double> getIncassoGiornata(){
        double incasso= 0.0;
        List<Scontrino> scontriniToday = scontrinoService.findByDate("today");
        for (Scontrino s: scontriniToday) {
            incasso += s.getImporto();
        }
        return ResponseEntity.ok(incasso);
    }

    @GetMapping("/incasso/prodotto/{day}")
    public ResponseEntity<String> getIncassoGiornataPerArticolo(@PathVariable String day){
        List<Scontrino> scontriniGiornoX = scontrinoService.findByDate(day);
        Map<String, List<Double>>  dettaglio = scontrinoService.getDettaglioPerProdotto(scontriniGiornoX);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/incasso/reparto/giornaliero/{day}")
    public ResponseEntity<String> getIncassoGiornataPerReparto(@PathVariable String day){
        List<Scontrino> scontriniGiornoX = scontrinoService.findByDate(day);
        Map<String, List<Double>>  dettaglio = scontrinoService.getDettaglioPerReparto(scontriniGiornoX);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/incasso/reparto/annuale/{year}")
    public ResponseEntity<String> getIncassoAnnualePerReparto(@PathVariable int year){
        List<Scontrino> scontriniAnnoX = scontrinoService.findByYear(year);
        Map<String, List<Double>>  dettaglio = scontrinoService.getDettaglioPerReparto(scontriniAnnoX);
        return ResponseEntity.ok("OK");
    }


}
