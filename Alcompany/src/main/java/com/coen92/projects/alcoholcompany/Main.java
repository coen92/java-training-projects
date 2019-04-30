package com.coen92.projects.alcoholcompany;

import com.coen92.projects.alcoholcompany.model.cargo.Bottle;
import com.coen92.projects.alcoholcompany.model.vehicles.Car;
import com.coen92.projects.alcoholcompany.model.vehicles.Truck;
import com.coen92.projects.alcoholcompany.model.vehicles.Vehicle;

public class Main {

    public static void main(String[] args) {

        Bottle[] bottles = new Bottle[10];

        for (int i=0; i<bottles.length; i++) {
            bottles[i] = new Bottle(5, 15);
        }

        bottles[2].transfer(2, bottles[4]);
        bottles[3].transfer(1, bottles[1]);
        bottles[5].transfer(5, bottles[8]);

        for (int i=0; i<bottles.length; i++) {

            System.out.println("\nBottle no. " + (i+1));
            bottles[i].showInfo();
        }

        Vehicle car = new Car();
        int carCapacity = car.getCrateCapacity();
        System.out.println(carCapacity);

        Vehicle truck = new Truck();
        int truckCapacity = truck.getCrateCapacity();
        System.out.println(truckCapacity);
    }
}
