package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL implements DatabaseConnectable {
    private final String host;
    private final String username;
    private final String password;
    private final String dbName;

    private Connection connection;

    public PostgreSQL(String host, String username, String password, String dbName) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    @Override
    public Connection getConnection() {
        String url = host + "/" + dbName;

        try {
            if (connection != null && !connection.isClosed()) return connection;

            // No need to check for JDBC driver existence, because we are using maven
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch (SQLException e) {
            System.out.println("Unable to establish a connection with database: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            System.out.println("Unable to close a connection: " + e.getMessage());
        }
    }
}
