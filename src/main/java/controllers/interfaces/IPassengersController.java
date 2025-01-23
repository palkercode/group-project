package controllers.interfaces;

import models.Flight;

public interface IPassengersController {
    String createPassenger(String name, String gender);
    String getPassengerById(int id);
    String getAllPassengers();
}
