package com.coen92.projects.alcoholcompany.model.vehicles;

public abstract class Vehicle {

    private String type;
    private int crateCapacity;
    private int speed;

    public Vehicle(String type, int crateCapacity, int speed) {
        this.type = type;
        this.crateCapacity = crateCapacity;
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public int getCrateCapacity() {
        return crateCapacity;
    }

    public int getSpeed() {
        return speed;
    }
}
