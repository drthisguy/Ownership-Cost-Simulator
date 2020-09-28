package com.drthisguy;

public class FuelTank extends CarPart {
    private final int tankSize;
    private final float mileage;


    private double fuelLevel;
    private int numberOfRefills = 0;
    private int numberOfPartReplacements = 0;

    public FuelTank(int tankSize) {
        super();
        this.tankSize = tankSize;
        this.fuelLevel = tankSize;
        this.mileage = 300 / (float)tankSize;
    }

    @Override
    public void function(int miles) {
        for (int i = 0; i < miles; i++) {
            this.fuelLevel = fuelLevel - (1 / this.mileage);
                if (this.fuelLevel <= 0) {
                    numberOfRefills++;
                    this.fuelLevel = this.tankSize;
                }
            this.setDurability(this.getDurability() - (0.025));
                if (this.getDurability() <= 0) {
                    numberOfPartReplacements++;
                    this.setDurability(3_000);
                }
        }
    }

    @Override
    public void status() {
        String message = this.fuelLevel > (this.tankSize/4.0) ? "good to go." : "running low.";
        if (this.getDurability() < 30)
            message += " And your fuel tank is starting to fail.";

        System.out.println("this " + this.tankSize + "-gallon tank is " + message);
    }

    @Override
    public int getOwnershipCost() {
        return (this.numberOfRefills * (tankSize * 2)) + (this.numberOfPartReplacements * 1000);
    }
}
