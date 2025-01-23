package repositories.interfaces;

import models.Flight;
import models.Passenger;

import java.util.List;

public interface IPassengersRepository {
    boolean createPassenger(Passenger passenger);
    boolean deletePassengerById(int id);
    Passenger getPassengerById(int id);
    List<Passenger> getAllPassengers();
}
