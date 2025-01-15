package repositories;

import configuration.DBConnection;
import dto.PostoRequest;
import entities.Posto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostoRepository {

    private static final Connection connection;

    static {
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Posto getById(Integer id) throws SQLException {
        String query = "SELECT * FROM posto WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return mapResultSetToPosto(resultSet);
        }
        else throw new IllegalArgumentException("Posto con id " + id + " non presente");
    }

    public static List<Posto> getAll() throws SQLException {
        String query = "SELECT * FROM posto";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Posto> posti = new ArrayList<>();
        while (resultSet.next()) {
            posti.add(mapResultSetToPosto(resultSet));
        }
        return posti;
    }

    public static List<Posto> getAllByIdSala(Integer idSala) throws SQLException {
        String query = "SELECT * FROM posto Where sala_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idSala);
        ResultSet resultSet = statement.executeQuery(query);
        List<Posto> posti = new ArrayList<>();
        while (resultSet.next()) {
            posti.add(mapResultSetToPosto(resultSet));
        }
        return posti;
    }

    public static void insertPosto(PostoRequest request) throws SQLException {
        String query = "INSERT INTO posto (fila,numero,sala_id)" +
                "VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, request.fila());
        statement.setInt(2,request.numero());
        statement.setInt(3,request.idSala());
        statement.executeUpdate();
    }

    public static void updatePosto(Integer id, PostoRequest request) throws SQLException {
        String query = "UPDATE posto SET fila = ?, numero = ?, sala_id = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, request.fila());
        statement.setInt(2,request.numero());
        statement.setInt(3,request.idSala());
        statement.setInt(4,id);
        statement.executeUpdate();
    }

    public static void deleteById(Integer id) throws SQLException {
        String query = "DELETE FROM posto WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    private static Posto mapResultSetToPosto(ResultSet resultSet) throws SQLException {
        Posto posto = new Posto();
        posto.setId(resultSet.getInt("id"));
        posto.setFila(resultSet.getInt("fila"));
        posto.setNumero(resultSet.getInt("numero"));
        posto.setIdSala(resultSet.getInt("sala_id"));
        return posto;
    }
}
