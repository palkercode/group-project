package database;

import java.sql.Connection;

public class PostgreSQL implements Connectable {
    private String host;
    private String username;
    private String password;
    private String dbName;

    private Connection connection;

    public PostgreSQL(String host, String username, String password, String dbName) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    @Override
    public Connection getConnection() {
        // TODO: da
    }

    @Override
    public void closeConnection() {

    }
}
