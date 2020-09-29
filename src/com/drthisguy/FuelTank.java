package com.drthisguy;

public class FuelTank extends CarPart {
    private int tankSize;
    private final float mileage;
    private double fuelLevel;
    private boolean gasIsPremium;
    private int numberOfRefills = 0;

    public FuelTank(int tankSize) {
        super(120_000);

        this.tankSize = tankSize;
        this.fuelLevel = tankSize;
        this.gasIsPremium = tankSize == 20 ? true : false;
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
                    this.setNumberOfReplacementParts();
                    this.setDurability(120_000);
                }
        }
    }

    @Override
    public int status() {
        boolean hasGas = this.fuelLevel > (this.tankSize/4.0);
        String message = hasGas ? "good to go." : "running low.";
        if (this.getDurability() < 36_000)
            message += (hasGas ? " However," : " And") + " your fuel tank is starting to fail.";

        System.out.println("Currently, your " + this.tankSize + "-gallon tank is " + message);
        System.out.println("You've gassed up your car "+ this.numberOfRefills + " time(s).");
        System.out.println("And you've replaced your tank "+ this.getNumberOfReplacementParts() + " time(s).");

        //Cost of gas conditioned on gas quality.
        return (int) ((numberOfRefills * (gasIsPremium ? (tankSize * 2.25) : (tankSize * 2)))
                + (getNumberOfReplacementParts() * 1000));
    }
}
