package controllers;

import controllers.interfaces.IPassengersController;
import models.Passenger;
import repositories.interfaces.IPassengersRepository;

import java.util.List;

public class PassengersController implements IPassengersController {
    private final IPassengersRepository passengersRepository;
    public void createPassenger(Passenger passenger) {
    }
    public PassengersController(IPassengersRepository passengersRepository) {
        this.passengersRepository = passengersRepository;
    }

    @Override
    public String createPassenger(String name, String gender) {
        boolean bGender = gender.equalsIgnoreCase("male");

        boolean created = passengersRepository.createPassenger(new Passenger(name, bGender));
        return created ? "Passenger was created: " : "Passenger creation failed";
    }

    @Override
    public String deletePassengerById(int id) {
        boolean deleted = passengersRepository.deletePassengerById(id);
        return deleted ? "Passenger was deleted" : "An error occured when tried to delete a passenger";
    }

    @Override
    public String getPassengerById(int id) {
        Passenger passenger = passengersRepository.getPassengerById(id);
        return passenger == null ? "Passenger does not exist" : passenger.toString();
    }

    @Override
    public String getAllPassengers() {
        List<Passenger> passengers = passengersRepository.getAllPassengers();

        StringBuilder response = new StringBuilder();

        for (Passenger passenger : passengers) {
            response.append(passenger).append("\n");
        }

        return response.toString();
    }

}
