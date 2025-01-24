package com.exercises.autocheckouts.repository;

import com.exercises.autocheckouts.model.Prodotto;
import com.exercises.autocheckouts.model.Scontrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScontrinoRepository  extends JpaRepository<Scontrino, Long> {
}
