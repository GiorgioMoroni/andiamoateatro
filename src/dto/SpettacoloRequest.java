package dto;

import validators.Validator;

import java.sql.Time;
import java.time.LocalDateTime;

public record SpettacoloRequest(
        LocalDateTime orario,
        String genere,
        Double prezzo,
        Integer durata,
        Integer idSede
){
    public SpettacoloRequest(LocalDateTime orario,
                             String genere,
                             Double prezzo,
                             Integer durata,
                             Integer idSede) {
        this.orario = (LocalDateTime) Validator.requireNotNull(orario);
        this.genere = Validator.requireNotBlank(genere);
        this.prezzo = Validator.requirePositive(prezzo);
        this.durata = (Integer) Validator.requireNotNull(durata);
        this.idSede = (Integer) Validator.requireNotNull(idSede);


    }



}
