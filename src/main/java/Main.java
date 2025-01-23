import controllers.interfaces.IPassengersController;
import controllers.PassengersController;
import database.DatabaseConnectable;
import database.PostgreSQL;
import repositories.interfaces.IPassengersRepository;
import repositories.PassengersRepository;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectable database = new PostgreSQL(
                "jdbc:postgresql://localhost:5432",
                "postgres",
                "underfan111",
                "airport-management-system"
        );

        IPassengersRepository passengerRepository = new PassengersRepository(database);
        IPassengersController passengersController = new PassengersController(passengerRepository);

        passengersController.createPassenger("asdasd", "male");

        database.closeConnection();
    }
}
