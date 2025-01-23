package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.service.PrezzoService;
import com.exercises.autocheckouts.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prezzo")
public class PrezzoController {

    @Autowired
    private final PrezzoService prezzoService;


    public PrezzoController(PrezzoService prezzoService) {
        this.prezzoService=prezzoService;
    }
}
