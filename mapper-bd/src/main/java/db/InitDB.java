package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitDB {
    private final String DB_URL = "jdbc:h2:mem:test;INIT=runscript from  + 'C:/Java/designJava/mapper-bd/src/main/resources/create.sql'";
    private final String DB_USER = "sa";
    private final String DB_PASSWORD = "";

    public Connection getConnection () throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("No connection with H2 Data Base");
        }
    }
}
