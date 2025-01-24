package com.exercises.autocheckouts.controller;

import com.exercises.autocheckouts.service.PrezzoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prezzo")
public class PrezzoController {

    private final PrezzoService prezzoService;
    public PrezzoController(PrezzoService prezzoService) {
        this.prezzoService=prezzoService;
    }
}
