package com.drthisguy;

public class Engine extends CarPart {
    private final int numberOfCylinders;
    private double oilQuality = 3_000;
    private int numberOfOilChanges = 0;
    private int numberOfPartReplacements = 0;


    public Engine(int numberOfCylinders) {
        super(150_000);
        this.numberOfCylinders = numberOfCylinders;
    }

    @Override
    public void function(int miles) {
        for (int i = 0; i < miles; i++) {
            this.oilQuality--;
                if(this.oilQuality == 0) {
                    this.numberOfOilChanges++;
                    this.oilQuality = 3_000;
                }
            this.setDurability(this.getDurability() - (oilQuality <= 500 ? 1.5 : 1)); //sets the engine wear based on oil quality.
                if(this.getDurability() <= 0) {
                    this.numberOfPartReplacements++;
                    this.setDurability(150_000);
                }
        }
    }

    @Override
    public void status() {
        String message = this.getDurability() >= 50 ? "purring like a kitten." : "in need of a tuneup.";
        if (this.oilQuality < 30)
            message += " And it needs an oil change.";

        System.out.println("this " + this.numberOfCylinders + "-cylinder engine is " + message);
    }

    @Override
    public int getOwnershipCost() {
        //cost of oil changes and engine replacements are higher for trucks or SUVs.
        return (numberOfOilChanges * (this.numberOfCylinders < 8 ? 35 : 45))
                + (numberOfPartReplacements * (this.numberOfCylinders < 8 ? 2500 : 3500));
    }

}
