package com.exercises.autocheckouts.repository;

import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByProdotto(Optional<Prodotto> prodotto);

    Stock findByDataBetween(Date startOfDay, Date endOfDay);

    Stock findByProdottoAndDataBetween(Prodotto prodotto, Date startOfDay, Date endOfDay);
}
