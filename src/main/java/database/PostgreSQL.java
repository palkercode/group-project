package database;

import java.sql.Connection;

public class PostgreSQL implements Connectable{
    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void closeConnection() {

    }
}
