import controllers.interfaces.IPassengersController;
import controllers.PassengersController;
import database.DatabaseConnectable;
import database.PostgreSQL;
import repositories.interfaces.IPassengersRepository;
import repositories.PassengersRepository;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Airport Management System ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. List Passengers");
            System.out.println("3. Get Passenger By ID");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter passenger gender (male/female): ");
                    String gender = scanner.nextLine();
                    System.out.println(passengersController.createPassenger(name, gender));
                    break;

                case 2:
                    System.out.println(passengersController.getAllPassengers());
                    break;

                case 3:
                    System.out.print("Enter Passenger ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(passengersController.getPassengerById(id));
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }

        database.closeConnection();
        scanner.close();
    }
}
