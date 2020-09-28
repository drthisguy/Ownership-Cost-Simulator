package com.drthisguy;

public class CarPart implements Useable {

    private double durability = 3_000;


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
