package repositories;

import configuration.DBConnection;
import dto.SpettacoloRequest;
import entities.Posto;
import entities.Spettacolo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SpettacoloRepository {

    private static final Connection connection;

    static {
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Spettacolo getById(Integer id) throws SQLException {
        String query = "SELECT * FROM spettacolo WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return mapResultSetToSpettacolo(resultSet);
        }
        else throw new IllegalArgumentException("Spettacolo con id " + id + " non presente");
    }

    public static List<Spettacolo> getAll() throws SQLException {
        String query = "SELECT * FROM spettacolo";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Spettacolo> spettacoli = new ArrayList<>();
        while (resultSet.next()) {
            spettacoli.add(mapResultSetToSpettacolo(resultSet));
        }
        return spettacoli;
    }



    public static void insertSpettacolo(SpettacoloRequest request) throws SQLException {
        String query = "INSERT INTO spettacolo (nome,orario,genere,prezzo,durata,sala_id)" +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,request.nome());
        statement.setTimestamp(2,Timestamp.valueOf(request.orario()));
        statement.setString(3,request.genere());
        statement.setDouble(4,request.prezzo());
        statement.setInt(5,request.durata());
        statement.setInt(6,request.idSala());
        statement.executeUpdate();
    }

    public static void updateSpettacolo(Integer id, SpettacoloRequest request) throws SQLException {
        String query = "UPDATE spettacolo SET nome = ?, orario = ?, genere = ?, prezzo = ?, durata = ?, sala_id = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,request.nome());
        statement.setTimestamp(2,Timestamp.valueOf(request.orario()));
        statement.setString(3,request.genere());
        statement.setDouble(4,request.prezzo());
        statement.setInt(5,request.durata());
        statement.setInt(6,request.idSala());
        statement.setInt(7,id);
        statement.executeUpdate();
    }

    public static void deleteById(Integer id) throws SQLException {
        String query = "DELETE FROM spettacolo WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    private static Spettacolo mapResultSetToSpettacolo(ResultSet resultSet) throws SQLException {
        Spettacolo spettacolo = new Spettacolo();
        spettacolo.setId(resultSet.getInt("id"));
        spettacolo.setGenere(resultSet.getString("nome"));
        spettacolo.setOrario(resultSet.getTimestamp("orario").toLocalDateTime());
        spettacolo.setGenere(resultSet.getString("genere"));
        spettacolo.setPrezzo(resultSet.getDouble("prezzo"));
        spettacolo.setDurata(resultSet.getInt("durata"));
        spettacolo.setIdSala(resultSet.getInt("sala_id"));
        return spettacolo;
    }

    public static List<Spettacolo> searchSpettacoli(String comune, LocalDateTime data) throws SQLException {
        String query = "SELECT * FROM spettacolo JOIN sala ON spettacolo.sala_id = sala.id JOIN sede ON sala.sede_id = sede.id WHERE sede.comune = ? AND DATE(spettacolo.orario) = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, comune);
        statement.setDate(2, java.sql.Date.valueOf(data.toLocalDate()));

        ResultSet resultSet = statement.executeQuery();
        List<Spettacolo> spettacoli = new ArrayList<>();

        while (resultSet.next()) {
            spettacoli.add(mapResultSetToSpettacolo(resultSet));
        }
        return spettacoli;

    }

    public static List<Spettacolo> searchSpettacoliBy4elementi(String comune, LocalDateTime data, String genere, Boolean bool) throws SQLException {
        String query = "SELECT * FROM spettacolo JOIN sala ON spettacolo.sala_id = sala.id JOIN sede ON sala.sede_id = sede.id WHERE sede.comune = ? AND DATE(spettacolo.orario) = ? AND spettacolo.genere = ? AND sede.tipo_luogo = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, comune);
        statement.setDate(2, java.sql.Date.valueOf(data.toLocalDate()));
        statement.setString(3, genere);
        statement.setBoolean(4, bool);

        ResultSet resultSet = statement.executeQuery();
        List<Spettacolo> spettacoli = new ArrayList<>();

        while (resultSet.next()) {
            spettacoli.add(mapResultSetToSpettacolo(resultSet));
        }
        return spettacoli;

    }
}
