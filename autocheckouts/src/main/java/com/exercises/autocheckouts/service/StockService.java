package com.exercises.autocheckouts.service;

import com.exercises.autocheckouts.model.Stock;
import com.exercises.autocheckouts.repository.ProdottoRepository;
import com.exercises.autocheckouts.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final StockRepository stockRepository;
    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
}
