package repositories;

import configuration.DBConnection;
import dto.PrenotazioneRequest;
import entities.Prenotazione;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneRepository {

    private static final Connection connection;

    static {
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Prenotazione getById(Integer id) throws SQLException {
        String query = "SELECT * FROM prenotazione WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return mapResultSetToPrenotazione(resultSet);
        }
        else throw new IllegalArgumentException("prenotazione con id " + id + " non presente");
    }

    public static List<Prenotazione> getAllByIdUtenteEIdSpettacolo(Integer idUtente, Integer idSpettacolo) throws SQLException {
        String query = "SELECT * FROM prenotazione WHERE utente_id = ? AND spettacolo_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idUtente);
        statement.setInt(2, idSpettacolo);
        ResultSet resultSet = statement.executeQuery();
        List<Prenotazione> prenotazioni = new ArrayList<>();
        while (resultSet.next()) {
            prenotazioni.add(mapResultSetToPrenotazione(resultSet));
        }

        return prenotazioni;
    }

    public static List<Prenotazione> getAllByIdSpettacolo(Integer idSpettacolo) throws SQLException {
        String query = "SELECT * FROM prenotazione WHERE spettacolo_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idSpettacolo);
        ResultSet resultSet = statement.executeQuery();
        List<Prenotazione> prenotazioni = new ArrayList<>();
        while (resultSet.next()) {
            prenotazioni.add(mapResultSetToPrenotazione(resultSet));
        }

        return prenotazioni;
    }



    public static List<Prenotazione> getAll() throws SQLException {
        String query = "SELECT * FROM prenotazione";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Prenotazione> prenotazioni = new ArrayList<>();
        while (resultSet.next()) {
            prenotazioni.add(mapResultSetToPrenotazione(resultSet));
        }
        return prenotazioni;
    }

    public static void insertPrenotazione(PrenotazioneRequest request) throws SQLException {
        String query = "INSERT INTO prenotazione (data_prenotazione,prezzo_totale, utente_id,spettacolo_id,posto_id)" +
                "VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setTimestamp(1,Timestamp.valueOf(request.dataPrenotazione()));
        statement.setDouble(2,request.prezzoTotale());
        statement.setInt(3, request.idUtente());
        statement.setInt(4, request.idSpettacolo());
        statement.setInt(5, request.idPosto());
        statement.executeUpdate();
    }

    public static void updatePrenotazione(Integer id, PrenotazioneRequest request) throws SQLException {
        String query = "UPDATE prenotazione SET data_prenotazione = ?, prezzo_totale = ?, utente_id = ?, spettacolo_id = ?, posto_id = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setTimestamp(1,Timestamp.valueOf(request.dataPrenotazione()));
        statement.setDouble(2,request.prezzoTotale());
        statement.setInt(3, request.idUtente());
        statement.setInt(4, request.idSpettacolo());
        statement.setInt(5, request.idPosto());
        statement.setInt(6, id);
        statement.executeUpdate();
    }

    public static void deleteById(Integer id) throws SQLException {
        String query = "DELETE FROM prenotazione WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    private static Prenotazione mapResultSetToPrenotazione(ResultSet resultSet) throws SQLException {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(resultSet.getInt("id"));
        prenotazione.setDataPrenotazione(resultSet.getTimestamp("data_prenotazione").toLocalDateTime());
        prenotazione.setPrezzoTotale(resultSet.getDouble("prezzo_totale"));
        prenotazione.setIdUtente(resultSet.getInt("utente_id"));
        prenotazione.setIdSpettacolo(resultSet.getInt("spettacolo_id"));
        prenotazione.setIdPosto(resultSet.getInt("posto_id"));
        return prenotazione;
    }


}
