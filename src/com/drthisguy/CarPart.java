package com.drthisguy;

public class CarPart implements Useable {

    private double durability;

    public CarPart(double durability) {
        this.durability = durability;
    }


    public void status() {}

    @Override
    public void function(int miles) {}

    public int getOwnershipCost() {
        return 0;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }
}
