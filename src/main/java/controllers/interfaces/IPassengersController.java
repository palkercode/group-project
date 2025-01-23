package controllers.interfaces;

import models.Flight;
import models.Passenger;

public interface IPassengersController {
    String createPassenger(String name, String gender);
    String deletePassengerById(int id);
    String getPassengerById(int id);
    String getAllPassengers();

    void createPassenger(Passenger passenger);
}
