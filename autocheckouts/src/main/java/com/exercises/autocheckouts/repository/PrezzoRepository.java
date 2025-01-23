package com.exercises.autocheckouts.repository;

import com.exercises.autocheckouts.model.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrezzoRepository extends JpaRepository<Barcode, Long> {

}
