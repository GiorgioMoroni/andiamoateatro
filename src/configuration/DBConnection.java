package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/andiamoateatro";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "CaesarAntonioZeppeli1234!";

    private static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

}
