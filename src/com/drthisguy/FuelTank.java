package com.drthisguy;

public class FuelTank extends CarPart {
    private final int tankSize;
    private final float mileage;
    private double fuelLevel;
    private int numberOfRefills = 0;
    private int numberOfPartReplacements = 0;

    public FuelTank(int tankSize) {
        super(120_000);

        this.tankSize = tankSize;
        this.fuelLevel = tankSize;
        this.mileage = 300 / (float)tankSize;
    }

    @Override
    public void function(float miles) {
        for (int i = 0; i < miles; i++) {
            this.fuelLevel = fuelLevel - (1 / this.mileage); //decrease fuel based on gas mileage.
                if (this.fuelLevel <= 0) {
                    numberOfRefills++;
                    this.fuelLevel = this.tankSize;
                }
            this.setDurability(this.getDurability() - 1);
                if (this.getDurability() <= 0) {
                    numberOfPartReplacements++;
                    this.setDurability(120_000);
                }
        }
    }

    @Override
    public int status() {
        boolean gassedUp = this.fuelLevel > (this.tankSize/4.0);
        String message = gassedUp ? "good to go." : "running low.";
        if (this.getDurability() < 30)
            message += gassedUp ? " However," : " And" + " your fuel tank is starting to fail.";

        System.out.println("Currently, your " + this.tankSize + "-gallon tank is " + message);
        System.out.println("You've gassed up your car "+ this.numberOfRefills + " time(s).");
        System.out.println("And you've replaced your tank "+ this.numberOfPartReplacements + " time(s).");

        return (this.numberOfRefills * (tankSize * 2)) + (this.numberOfPartReplacements * 1000);
    }
}
