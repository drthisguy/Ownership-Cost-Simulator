package com.drthisguy;

public class Engine extends CarPart {
    private final int numberOfCylinders;
    private double oilQuality = 3_000;
    private int numberOfOilChanges = 0;
    private int numberOfPartReplacements = 0;



    public Engine(int numberOfCylinders) {
        super();
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
            this.setDurability(this.getDurability() - (oilQuality < 500 ? 0.003 : 0.002)); //sets the engine wear based on oil quality.
                if(this.getDurability() <= 0) {
                    this.numberOfPartReplacements++;
                    this.setDurability(3_000);
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
        return (numberOfOilChanges * 35) + (numberOfPartReplacements * 2500);
    }

}
