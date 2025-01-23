package repositories;

import database.DatabaseConnectable;
import models.Flight;
import models.Passenger;
import repositories.interfaces.IPassengersRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengersRepository implements IPassengersRepository {
    private final DatabaseConnectable database;

    public PassengersRepository(DatabaseConnectable database) {
        this.database = database;
    }

    @Override
    public boolean createPassenger(Passenger passenger) {
        Connection connection = database.getConnection();

        String query = "INSERT INTO passengers (name, gender) VALUES (?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, passenger.getName());
            statement.setBoolean(2, passenger.getGender());

            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to create passenger: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deletePassengerById(int id) {
        Connection connection = database.getConnection();

        String query = "DELETE FROM passengers WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to delete passenger: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Passenger getPassengerById(int id) {
        Connection connection = database.getConnection();

        String query = "SELECT * FROM passengers WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Passenger(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("gender")
                );
            }
        }
        catch (SQLException e) {
            System.out.println("Passenger not found: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = new ArrayList<>();

        Connection connection = database.getConnection();

        String query = "SELECT * FROM passengers";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                passengers.add(new Passenger(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("gender")
                ));
            }

            return passengers;
        }
        catch (SQLException e) {
            System.out.println("Unable to get all passengers: " + e.getMessage());
        }

        return null;
    }
}
