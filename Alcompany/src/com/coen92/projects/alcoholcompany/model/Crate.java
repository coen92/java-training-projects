package com.coen92.projects.alcoholcompany.model;

import com.coen92.projects.alcoholcompany.api.IFillable;

public class Crate implements IFillable {

    private static int id = 0;
    private int slots;
    private Bottle[] bottles;

    public Crate(int slots) {
        id++;
        this.slots = slots;
        this.bottles = new Bottle[slots];
    }

    public static int getId() {
        return id;
    }

    public int getSlots() {
        return slots;
    }

    public Bottle[] getBottles() {
        return bottles;
    }

    @Override
    public boolean isFull() {
        Crate crate = this;
        Bottle[] bottles = crate.getBottles();

        for(Bottle bottle : bottles) {
            if(bottle.isFull()) {
                if (bottles.length == crate.getSlots()) {
                    return true;
                }
            }
        }
        return false;
    }
}
