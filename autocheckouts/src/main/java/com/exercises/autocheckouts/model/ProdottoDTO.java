package com.exercises.autocheckouts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class ProdottoDTO {

    private Long id;
    private String nome;
    private String reparto;
    private int grammatura;
    private Unit unit;


    public static ProdottoDTO convertToDTO(Prodotto prodotto) {
        ProdottoDTO userDTO = new ProdottoDTO();
        userDTO.setId(prodotto.getId());
        userDTO.setId(prodotto.getId());
        userDTO.setNome(prodotto.getNome());
        userDTO.setGrammatura(prodotto.getGrammatura());
        userDTO.setUnit(prodotto.getUnit());
        userDTO.setReparto(prodotto.getReparto());
        return userDTO;
    }
}
