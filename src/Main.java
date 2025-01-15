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
        System.out.println(UtenteService.searchSpettacoli("Roma", LocalDateTime.of(2025, 3, 22, 20, 30, 0)));

        //Metodo verifica che un utente non può effettuare più di quattro prenotazioni
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 1, 1, 5));

        //Metodo verifica che un utente non può prenotare un posto gia prenotato
//        UtenteService.eseguiPrenotazione(new PrenotazioneRequest(LocalDateTime.now(), 15.80, 3, 1, 1));




    }
}
