package models;

import java.util.List;

public class Flight {
    private int id;
    private String name;
    private String destination;

    public Flight(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }

    public Flight(int id, String name, String destination) {
        this(name, destination);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
