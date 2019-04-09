package com.coen92.projects.placarding.model;

public class Building {

    private int buildingNumber;
    private int buildingLength;
    private int buildingHeight;

    public Building(int buildingNumber, int buildingLength, int buildingHeight) {
        this.buildingNumber = buildingNumber;
        this.buildingLength = buildingLength;
        this.buildingHeight = buildingHeight;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getBuildingLength() {
        return buildingLength;
    }

    public int getBuildingHeight() {
        return buildingHeight;
    }
}
