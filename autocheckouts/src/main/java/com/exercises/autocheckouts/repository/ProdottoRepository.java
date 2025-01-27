package com.exercises.autocheckouts.repository;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
        Prodotto findByBarcodes(Barcode barcode);
}
