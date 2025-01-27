package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Scontrino;
import com.exercises.autocheckouts.repository.ScontrinoRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ScontrinoService {
    private final ScontrinoRepository scontrinoRepository;
    private final PrezzoService prezzoService;

    public ScontrinoService(ScontrinoRepository scontrinoRepository, PrezzoService prezzoService) {
        this.scontrinoRepository = scontrinoRepository;
        this.prezzoService = prezzoService;
    }

    public Scontrino aggiungiScontrino(List<Barcode> dettaglio) {
        Double tot = prezzoService.calculatePrezzoByBarcode(dettaglio);
        Scontrino scontrino = new Scontrino(null, tot, new Date(), dettaglio);
        return scontrinoRepository.save(scontrino);
    }

    public List<Scontrino> findByTodayDate() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startOfDay = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date endOfDay = calendar.getTime();

        List<Scontrino> scontrini = scontrinoRepository.findByDataBetween(startOfDay, endOfDay);
        return scontrini;
    }
}
