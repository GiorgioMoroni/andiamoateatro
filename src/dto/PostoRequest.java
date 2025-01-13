package dto;

import validators.Validator;

import java.time.LocalDateTime;

public record PostoRequest(
        Character fila,
        Integer numero,
        Integer idSala
){
    public PostoRequest(Character fila,
                        Integer numero,
                        Integer idSala) {
        this.fila = Validator.requireBetween(fila);
        this.numero = Validator.requireGreaterThanZero(numero);
        this.idSala = (Integer) Validator.requireNotNull(idSala);

    }

}