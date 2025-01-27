package com.exercises.autocheckouts.model;

import lombok.Data;

import java.util.Date;
@Data
public class ScontrinoDTO {
    private Long id;
    private Double importo;
    private Date data;

    public static ScontrinoDTO convertToDTO(Scontrino scontrino) {
        ScontrinoDTO scontrinoDTO = new ScontrinoDTO();
        scontrinoDTO.setId(scontrino.getId());
        scontrinoDTO.setData(scontrino.getData());
        scontrinoDTO.setImporto(scontrino.getImporto());
        return scontrinoDTO;
    }
}
