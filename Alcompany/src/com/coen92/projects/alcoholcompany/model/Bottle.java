package com.coen92.projects.alcoholcompany.model;

public class Bottle {

    private double litre;
    private double capacity;

    public Bottle(double litre, double capacity) {
        this.litre = litre;
        this.capacity = capacity;
    }

    public double getLitre() {
        return litre;
    }

    public double getCapacity() {
        return capacity;
    }

    boolean pour(double volume) {
        if(this.capacity >= litre) {
            this.litre += volume;
        } else {
            return false;
        }
        return true;
    }

    boolean spill(double volume) {
        if(volume <= litre) {
            this.litre -= volume;
        } else {
            return false;
        }
        return true;
    }

    public void transfer(double volume, Bottle whereTo) {

        double x = this.getLitre();
        double y = whereTo.getCapacity() - whereTo.getLitre();

        double howMuchToTransfer = x < y ? x : y;

        if(howMuchToTransfer >= volume) {
            this.spill(volume);
            whereTo.pour(volume);
        } else {
            System.out.println("Not enough space in bottle to pour full volume");
            System.out.println("You can transfer only: " + howMuchToTransfer + "\n");
            this.spill(howMuchToTransfer);
            whereTo.pour(howMuchToTransfer);
        }
    }

    public void showInfo() {

        System.out.println("Litres in bottle: " + getLitre() +
                "\nCapacity of bottle: " + getCapacity());
    }
}
