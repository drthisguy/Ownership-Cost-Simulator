package com.drthisguy;

public class CarPart implements Useable {

    private double durability;

    public CarPart(double durability) {
        this.durability = durability;
    }

    public int status() {
        return 0;
    }

    @Override
    public void function(float miles) {}

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }
}
