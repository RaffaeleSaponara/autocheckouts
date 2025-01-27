package com.exercises.autocheckouts.repository;

import com.exercises.autocheckouts.model.Scontrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScontrinoRepository  extends JpaRepository<Scontrino, Long> {
    List<Scontrino> findByDataBetween(Date inizio, Date fine);
}
