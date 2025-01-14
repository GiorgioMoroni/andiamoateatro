package dto;

import validators.Validator;

import java.time.LocalDateTime;

public record SpettacoloRequest(
        String nome,
        LocalDateTime orario,
        String genere,
        Double prezzo,
        Integer durata,
        Integer idSala
){
    public SpettacoloRequest(String nome,
                            LocalDateTime orario,
                            String genere,
                            Double prezzo,
                            Integer durata,
                            Integer idSala) {
        this.nome = Validator.requireNotBlank(nome);
        this.orario = (LocalDateTime) Validator.requireNotNull(orario);
        this.genere = Validator.requireNotBlank(genere);
        this.prezzo = Validator.requirePositive(prezzo);
        this.durata = (Integer) Validator.requireNotNull(durata);
        this.idSala = (Integer) Validator.requireNotNull(idSala);


    }



}
