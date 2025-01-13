package dto;

import validators.Validator;

import java.time.LocalDateTime;

public record SalaRequest(
        String nome,
        Integer numeroPosti,
        Integer idSede
){
    public SalaRequest(String nome,
                       Integer numeroPosti,
                       Integer idSede) {
        this.nome = Validator.requireNotBlank(nome);
        this.numeroPosti = Validator.requireGreaterThanZero(numeroPosti);
        this.idSede = (Integer) Validator.requireNotNull(idSede);


    }

}