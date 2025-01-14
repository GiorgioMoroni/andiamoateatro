package dto;

import validators.Validator;


public record PostoRequest(
        Integer fila,
        Integer numero,
        Integer idSala
){
    public PostoRequest(Integer fila,
                        Integer numero,
                        Integer idSala) {
        this.fila = (Integer) Validator.requireNotNull(fila);
        this.numero = Validator.requireGreaterThanZero(numero);
        this.idSala = (Integer) Validator.requireNotNull(idSala);

    }

}