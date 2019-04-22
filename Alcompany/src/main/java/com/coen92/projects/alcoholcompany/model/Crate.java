package com.coen92.projects.alcoholcompany.model;

import com.coen92.projects.alcoholcompany.api.IFillable;

import java.util.ArrayList;
import java.util.List;

public class Crate implements IFillable {
    private static int id = 0;
    private int slots;
    private List<Bottle> bottles;

    public Crate(int slots) {
        id++;
        this.slots = slots;
        this.bottles = new ArrayList<>();
    }

    public static int getId() {
        return id;
    }

    public int getSlots() {
        return slots;
    }

    public List<Bottle> getBottles() {
        return bottles;
    }

    @Override
    public boolean isFull() {
        Crate crate = this;
        List<Bottle> bottles = crate.getBottles();

        for(Bottle bottle : bottles) {
            if(bottle.isFull()) {
                if (bottles.size() == crate.getSlots()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addBottle(Bottle bottle) {
        if(!bottle.isFull()) {
            System.out.println("Fill the bottle before adding to the crate");
            return false;
        } else if (this.isFull()) {
            System.out.println("Crate is full. You can't add another bottle");
            return false;
        } else {
            System.out.println("Bottle added to the crate no. " + getId());
            Crate crate = this;
            List<Bottle> bottles = crate.getBottles();
            bottles.add(bottle);
            return true;
        }
    }

    public boolean removeBottle(Bottle bottle) {
        Crate crate = this;
        if(crate.getBottles().isEmpty()) {
            System.out.println("Crate is empty! No bottles to remove");
            return false;
        } else {
            System.out.println("Removed a bottle from a crate no. " + getId());
            crate.getBottles().remove(bottle);
            return true;
        }
    }

    public static int getEmptySlotsNumber(Crate crate) {
        return crate.getSlots() - crate.getBottles().size();
    }

    public void getCrateInfo(Crate crate) {
        System.out.println("Crate number: " + getId()
                + "\nCapacity: " + crate.getSlots()
                + "\nEmpty slots: " + getEmptySlotsNumber(crate));
    }
}
