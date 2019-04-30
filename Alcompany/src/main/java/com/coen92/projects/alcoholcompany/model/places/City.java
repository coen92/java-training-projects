package com.coen92.projects.alcoholcompany.model.places;

public class City extends Place {

    private String cityName;
    private long population;

    public City(double coordinateX, double coordinateY) {
        super(coordinateX, coordinateY);
    }

    public City(double coordinateX, double coordinateY, String cityName, long population) {
        super(coordinateX, coordinateY);
        this.cityName = cityName;
        this.population = population;
    }

    public String getCityName() {
        return cityName;
    }

    public long getPopulation() {
        return population;
    }
}
