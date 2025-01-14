package dto;

import validators.Validator;

public record UtenteRequest(
        String nome,
        String cognome,
        String email,
        String indirizzo,
        String telefono
) {

    public UtenteRequest(String nome,
                         String cognome,
                         String email,
                         String indirizzo,
                         String telefono) {
        this.nome = Validator.requireNotBlank(nome);
        this.cognome = Validator.requireNotBlank(cognome);
        this.email = Validator.validRegex(email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        this.indirizzo = Validator.requireNotBlank(indirizzo);
        this.telefono = Validator.validRegexOrNull(telefono, "^\\+([1-9]{1,4})(\\d{1,4})(\\d{1,4})(\\d{1,4})$");
    }

}
