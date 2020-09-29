package com.drthisguy;

public class CarPart implements Usable {

    private double durability;
    private int numberOfReplacementParts = 0;

    public CarPart(double durability) {
        this.durability = durability;
    }

    @Override
    public void function(float miles) {}

    public int status() {
        return 0;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public int getNumberOfReplacementParts() {
        return numberOfReplacementParts;
    }

    public void setNumberOfReplacementParts(int numberOfReplacementParts) {
        this.numberOfReplacementParts = numberOfReplacementParts;
    }
}
