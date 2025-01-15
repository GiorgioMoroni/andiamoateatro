package services;

import dto.PrenotazioneRequest;
import dto.SpettacoloRequest;
import dto.UtenteRequest;
import entities.*;
import repositories.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class UtenteService {

    public Utente getUtenteById(Integer id) throws SQLException {
        return UtenteRepository.getById(id);
    }

    public List<Utente> getAllUtenti() throws SQLException {
        return UtenteRepository.getAll();
    }

    public void insertUtente(UtenteRequest request) throws SQLException {
        UtenteRepository.insertUtente(request);
    }

    public void updateUtente(Integer id, UtenteRequest request) throws SQLException {
        UtenteRepository.updateUtente(id, request);
    }

    public void deleteUtenteById(Integer id) throws SQLException {
        UtenteRepository.deleteById(id);
    }

    public static List<Spettacolo> searchSpettacoli(String comune, LocalDateTime data) throws SQLException {
        return SpettacoloRepository.searchSpettacoli(comune, data);
    }

    public static List<Spettacolo> searchSpettacoliBy4Elementi(String comune, LocalDateTime data, String genere, Boolean bool) throws SQLException {
        return SpettacoloRepository.searchSpettacoliBy4elementi(comune, data, genere, bool);
    }

    public static void eseguiPrenotazione(PrenotazioneRequest request) throws SQLException {
        Spettacolo spettacolo = SpettacoloRepository.getById(request.idSpettacolo());
        Integer idSalaSpettacolo = spettacolo.getIdSala();
        Posto posto = PostoRepository.getById(request.idPosto());
        Integer idSalaPosto = posto.getIdSala();
        Sala sala = SalaRepository.getById(idSalaSpettacolo);
        Integer numeroPostiSala = sala.getNumeroPosti();

        if(PrenotazioneRepository.getAllByIdUtenteEIdSpettacolo(request.idUtente(), request.idSpettacolo()).size() >= 4){
            throw new IllegalArgumentException("Utente " + request.idUtente() + " ha gia effettuato il numero massimo di prenotazioni per lo spettacolo " + request.idSpettacolo());
        }
        else if(PrenotazioneRepository.getAll().stream().anyMatch(prenotazione -> prenotazione.getIdPosto().equals(request.idPosto()))){
            throw new IllegalArgumentException("Posto " + request.idPosto() + " già acquistato e non disponibile");
        }
        else if (!idSalaSpettacolo.equals(idSalaPosto)) {
            throw new IllegalArgumentException("Il posto " + request.idPosto() + " non fa parte della sala per lo spettacolo " + request.idSpettacolo());
        }
        else if(PrenotazioneRepository.getAllByIdSpettacolo(request.idSpettacolo()).size() > numeroPostiSala){
            throw new IllegalArgumentException("Sala " + idSalaSpettacolo + " al completo");
        }
        PrenotazioneRepository.insertPrenotazione(request);
    }



}
