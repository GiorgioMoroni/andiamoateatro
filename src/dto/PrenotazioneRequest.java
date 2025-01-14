package dto;

import validators.Validator;

import java.time.LocalDateTime;

public record PrenotazioneRequest(
        LocalDateTime dataPrenotazione,
        Double prezzoTotale,
        Integer idUtente,
        Integer idSpettacolo,
        Integer idPosto
){
    public PrenotazioneRequest(LocalDateTime dataPrenotazione,
                               Double prezzoTotale,
                               Integer idUtente,
                               Integer idSpettacolo,
                               Integer idPosto) {
        this.dataPrenotazione = LocalDateTime.now();
        this.prezzoTotale = Validator.requirePositive(prezzoTotale);
        this.idUtente = (Integer) Validator.requireNotNull(idUtente);
        this.idSpettacolo = (Integer) Validator.requireNotNull(idSpettacolo);
        this.idPosto = (Integer) Validator.requireNotNull(idPosto);

    }

}



