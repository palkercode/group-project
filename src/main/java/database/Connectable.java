package database;

import java.sql.Connection;

public interface Connectable {
    Connection getConnection();
    void closeConnection();
}
