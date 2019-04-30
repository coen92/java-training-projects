package com.coen92.projects.alcoholcompany.model.cargo;

import com.coen92.projects.alcoholcompany.api.IMoveable;
import com.coen92.projects.alcoholcompany.model.places.City;
import com.coen92.projects.alcoholcompany.model.places.Place;
import com.coen92.projects.alcoholcompany.model.vehicles.Vehicle;

public class Transport implements IMoveable {

    private Vehicle vehicle;
    private City departureCity;
    private City destinationCity;
    private long distance;

    public Transport(Vehicle vehicle, City departureCity, City destinationCity) {
        this.vehicle = vehicle;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.distance = countDistance(departureCity, destinationCity);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public long getDistance() {
        return distance;
    }

    private long countDistance(City departure, City destination) {
        long deltaX = (long)(destination.getCoordinateX() - departure.getCoordinateX());
        long deltaY = (long)(destination.getCoordinateY() - departure.getCoordinateY());
        long distance = (long) Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));

        return Math.abs(distance);
    }

    @Override
    public void move(Place departure, Place destination) {

    }
}
