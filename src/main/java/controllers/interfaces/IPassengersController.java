package controllers.interfaces;

import models.Flight;

public interface IPassengersController {
    String createPassenger(String name, String gender);
    String deletePassengerById(int id);
    String getPassengerById(int id);
    String getAllPassengers();
}
