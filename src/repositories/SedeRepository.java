package repositories;

import configuration.DBConnection;
import dto.SedeRequest;
import entities.Sede;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SedeRepository {

    private static final Connection connection;

    static {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Sede getById(Integer id) throws SQLException {
        String query = "SELECT * FROM sede WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return mapResultSetToSede(resultSet);
        }
        else throw new IllegalArgumentException("Sede con id " + id + " non presente");
    }

    public static List<Sede> getAll() throws SQLException {
        String query = "SELECT * FROM sede";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Sede> sedi = new ArrayList<>();
        while (resultSet.next()) {
            sedi.add(mapResultSetToSede(resultSet));
        }
        return sedi;
    }

    public static void insertSede(SedeRequest request) throws SQLException {
        String query = "INSERT INTO sede (nome,indirizzo,comune,tipo_luogo)" +
                "VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, request.nome());
        statement.setString(2, request.indirizzo());
        statement.setString(3, request.comune());
        statement.setBoolean(4, request.tipoLuogo());
        statement.executeUpdate();

    }

    public static void updateSede(Integer id, SedeRequest request) throws SQLException {
        String query = "UPDATE sede SET nome = ?, indirizzo = ?, comune = ?, tipo_luogo = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,request.nome());
        statement.setString(2,request.indirizzo());
        statement.setString(3,request.comune());
        statement.setBoolean(4,request.tipoLuogo());
        statement.setInt(5,id);
        statement.executeUpdate();
    }

    public static void deleteById(Integer id) throws SQLException {
        String query = "DELETE FROM sede WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }


    private static Sede mapResultSetToSede(ResultSet resultSet) throws SQLException {
        Sede sede = new Sede();
        sede.setId(resultSet.getInt("id"));
        sede.setNome(resultSet.getString("nome"));
        sede.setIndirizzo(resultSet.getString("indirizzo"));
        sede.setComune(resultSet.getString("comune"));
        sede.setTipoLuogo(resultSet.getBoolean("tipo_luogo"));
        return sede;
    }
}
