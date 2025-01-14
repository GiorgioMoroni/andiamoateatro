package dto;

import validators.Validator;


public record SedeRequest(
        String nome,
        String indirizzo,
        String comune,
        Boolean tipoLuogo

){
    public SedeRequest(String nome,
                       String indirizzo,
                       String comune,
                       Boolean tipoLuogo) {

        this.nome = Validator.requireNotBlank(nome);
        this.indirizzo = Validator.requireNotBlank(indirizzo);
        this.comune = Validator.requireNotBlank(comune);
        this.tipoLuogo = (Boolean) Validator.requireNotNull(tipoLuogo);
    }

}