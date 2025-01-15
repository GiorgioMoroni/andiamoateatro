package repositories;

import configuration.DBConnection;
import dto.SalaRequest;
import entities.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaRepository {

    private static final Connection connection;

    static {
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Sala getById(Integer id) throws SQLException {
        String query = "SELECT * FROM sala WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return mapResultSetToSala(resultSet);
        }
        else throw new IllegalArgumentException("Sala con id " + id + " non presente");
    }

    public static List<Sala> getAll() throws SQLException {
        String query = "SELECT * FROM sala";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Sala> sale = new ArrayList<>();
        while (resultSet.next()) {
            sale.add(mapResultSetToSala(resultSet));
        }
        return sale;
    }

    public static void insertSala(SalaRequest request) throws SQLException {
        String query = "INSERT INTO sala (nome,numero_posti,sede_id)" +
                "VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,request.nome());
        statement.setInt(2,request.numeroPosti());
        statement.setInt(3,request.idSede());
        statement.executeUpdate();
    }

    public static void updateSala(Integer id, SalaRequest request) throws SQLException {
        String query = "UPDATE sala SET nome = ?, numero_posti = ?, sede_id = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,request.nome());
        statement.setInt(2,request.numeroPosti());
        statement.setInt(3,request.idSede());
        statement.setInt(4,id);
        statement.executeUpdate();
    }

    public static void deleteById(Integer id) throws SQLException {
        String query = "DELETE FROM sala WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    private static Sala mapResultSetToSala(ResultSet resultSet) throws SQLException {
        Sala sala = new Sala();
        sala.setId(resultSet.getInt("id"));
        sala.setNome(resultSet.getString("nome"));
        sala.setNumeroPosti(resultSet.getInt("numero_posti"));
        sala.setIdSede(resultSet.getInt("sede_id"));
        return sala;
    }
}
