package com.exercises.autocheckouts.repository;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeRepository  extends JpaRepository<Barcode, Long> {
}
