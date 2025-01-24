import controllers.interfaces.IPassengersController;
import controllers.PassengersController;
import database.DatabaseConnectable;
import database.PostgreSQL;
import models.Passenger;
import repositories.interfaces.IPassengersRepository;
import repositories.PassengersRepository;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
        Scanner consoleScanner = new Scanner(System.in);

        while (running) {
            System.out.println("\n=== Airport Management System ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. List Passengers");
            System.out.println("3. Get Passenger By ID");
            System.out.println("4. Import passengers from file");
            System.out.println("5. Add Flight");
            System.out.println("6. List Flights");
            System.out.println("7. Get Flight By ID");
            System.out.println("8. Exit");
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
                    Collections.sort(passengerRepository.getAllPassengers());
                    System.out.println(passengersController.getAllPassengers());
                    break;

                case 3:
                    System.out.print("Enter Passenger ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(passengersController.getPassengerById(id));
                    break;

                case 4:
                    System.out.print("Enter the file path: ");
                    String path = consoleScanner.nextLine();
                    while (scanner.hasNextLine()) {
                        Passenger passenger = new Passenger();
                        passenger.setName(scanner.next());
                        passenger.setGender(scanner.next().equalsIgnoreCase("male"));
                        passengersController.createPassenger(passenger);
                        break;
                    }
                case 5:
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter departure time: ");
                    String departureTime = scanner.nextLine();
                    System.out.println("Flight added successfully (functionality to be implemented).\n");
                    break;

            case 6:
                System.out.println("List of flights (functionality to be implemented).\n");
                break;

                case 7:
                    System.out.print("Enter Flight ID: ");
                    int flightId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Flight details (functionality to be implemented).\n");
                    break;

                case 8:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again!\n");
            }
        }

        database.closeConnection();
        scanner.close();
    }
}