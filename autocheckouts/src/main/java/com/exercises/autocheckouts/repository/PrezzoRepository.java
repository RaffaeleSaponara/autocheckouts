package com.exercises.autocheckouts.repository;

import com.exercises.autocheckouts.model.Barcode;
import com.exercises.autocheckouts.model.Prezzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrezzoRepository extends JpaRepository<Prezzo, Long> {
        Optional<Prezzo> findByBarcode(Barcode barcode);
        Prezzo findPrezzoByBarcode(Barcode barcode);
}
