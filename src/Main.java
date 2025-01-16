import dto.*;
import entities.Utente;
import repositories.*;
import services.UtenteService;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException {

//        UtenteRepository.insertUtente(new UtenteRequest("Gaetano", "Latanza", "gaetano.latanza@example.com", "Viale Puglia 666", "+393334455678"));
//        UtenteRepository.insertUtente(new UtenteRequest("Alessandro", "Polioni", "alessandro.polioni@example.com", "Viale Roma 666", "+393334455679"));

//        SedeRepository.insertSede(new SedeRequest("Teatro Brancaccio", "Via Bari 23", "Roma", true));

//        SalaRepository.insertSala(new SalaRequest("Sala 1", 50, 1));

//        PostoRepository.insertPosto(new PostoRequest(1, 1, 1));
//        PostoRepository.insertPosto(new PostoRequest(1, 2, 1));
//        PostoRepository.insertPosto(new PostoRequest(1, 3, 1));
//        PostoRepository.insertPosto(new PostoRequest(1, 4, 1));
//        PostoRepository.insertPosto(new PostoRequest(1, 5, 1));

//        SpettacoloRepository.insertSpettacolo((new SpettacoloRequest("3 uomini e una gamba", LocalDateTime.of(2025, 3, 22, 20, 30, 0), "commedia", 15.80, 2, 1)));

//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 1, 1));
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 1, 2));
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 1, 3));
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 1, 4));


        //Metodo ricerca spettacoli
//        System.out.println(UtenteService.searchSpettacoli("Roma", LocalDateTime.of(2025, 3, 22, 20, 30, 0)));

        //Metodo verifica che un utente non può effettuare più di quattro prenotazioni
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 1, 5));

        //Metodo verifica che un utente non può prenotare un posto gia prenotato
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 3, 1, 1));


//        SpettacoloRepository.insertSpettacolo((new SpettacoloRequest("Ricomincio da tre", LocalDateTime.of(2025, 1, 11, 20, 30, 0), "drammatico", 15.80, 2, 1)));
//        SpettacoloRepository.insertSpettacolo((new SpettacoloRequest("Ricomincio da quattro", LocalDateTime.of(2025, 1, 12, 20, 30, 0), "drammatico", 15.80, 2, 1)));
//        SpettacoloRepository.insertSpettacolo((new SpettacoloRequest("Ricomincio da cinque", LocalDateTime.of(2025, 1, 13, 20, 30, 0), "drammatico", 15.80, 2, 1)));

//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 5, 1));
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 6, 2));
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 7, 3));

//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("La commedia della vita", LocalDateTime.of(2025, 1, 18, 21, 0), "commedia", 12.50, 3, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Terrore al cinema", LocalDateTime.of(2025, 1, 20, 22, 15), "horror", 18.00, 5, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Il grande dramma", LocalDateTime.of(2025, 1, 22, 19, 30), "drammatico", 16.00, 4, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Festa di risate", LocalDateTime.of(2025, 1, 23, 18, 0), "commedia", 14.00, 6, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Notte di paura", LocalDateTime.of(2025, 1, 25, 23, 0), "horror", 17.50, 7, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Vita in bilico", LocalDateTime.of(2025, 1, 27, 20, 45), "drammatico", 15.00, 8, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Ridere fa bene", LocalDateTime.of(2025, 1, 28, 19, 0), "commedia", 13.20, 9, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Incubo notturno", LocalDateTime.of(2025, 2, 1, 22, 30), "horror", 19.00, 10, 1));
//        SpettacoloRepository.insertSpettacolo(new SpettacoloRequest("Lacrime sul palco", LocalDateTime.of(2025, 2, 3, 20, 0), "drammatico", 17.30, 11, 1));

        System.out.println(SpettacoloRepository.suggerimentoSpettacoli(1));





    }
}
