package dto;

import validators.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record PrenotazioneRequest(
        Integer numeroPosti,
        LocalDateTime dataPrenotazione,
        Double prezzoTotale,
        Integer idUtente,
        Integer idSpettacolo
){
    public PrenotazioneRequest(Integer numeroPosti,
                               LocalDateTime dataPrenotazione,
                               Double prezzoTotale,
                               Integer idUtente,
                               Integer idSpettacolo) {
        this.numeroPosti = Validator.requireBetween(numeroPosti, 1, 4);
        this.dataPrenotazione = LocalDateTime.now();
        this.prezzoTotale = Validator.requirePositive(prezzoTotale);
        this.idUtente = (Integer) Validator.requireNotNull(idUtente);
        this.idSpettacolo = (Integer) Validator.requireNotNull(idSpettacolo);


    }

}



