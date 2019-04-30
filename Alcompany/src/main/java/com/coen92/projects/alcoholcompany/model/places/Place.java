package com.coen92.projects.alcoholcompany.model.places;

public abstract class Place {

    private double coordinateX;
    private double coordinateY;

    public Place(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }
}
