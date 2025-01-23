package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.repository.PrezzoRepository;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrezzoService {
    private final PrezzoRepository prezzoRepository;

    @Autowired
    public PrezzoService(PrezzoRepository prezzoRepository) {
        this.prezzoRepository = prezzoRepository;
    }
}
