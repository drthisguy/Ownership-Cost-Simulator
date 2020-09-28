package com.drthisguy;

public class Wheels extends CarPart {
    private boolean isPremium;
    private double tireTread = isPremium ? 30_000 : 22_500;
    private int numberOfTireReplacements = 0;
    public int numberOfPartReplacements = 0;

    public Wheels(boolean isPremium) {
        super();
        this.isPremium = isPremium;
    }

    @Override
    public void function(int miles) {
        for (int i = 0; i < miles; i++) {
            this.tireTread--;
                if(tireTread == 0) {
                    this.numberOfTireReplacements++;
                    this.tireTread = isPremium ? 30_000 : 22_500;
                }
            this.setDurability(this.getDurability() - (this.isPremium ? (0.04) : (0.006))); //part wear based on part quality.
                if(this.getDurability() <= 0) {
                    numberOfPartReplacements++;
                    this.setDurability(3_000);
                }
        }
    }

    @Override
    public void status() {
        String message = this.tireTread > (tireTread/3) ? "are looking good" : "have low, tire tread";
        if (this.getDurability() < 30)
            message += " Your " + (this.isPremium ? "premium " : "") + "wheels are starting to fail.";

        System.out.println("these " + (this.isPremium ? "premium " : "") + "tires " + message);
    }

    @Override
    public int getOwnershipCost() {
        return (this.numberOfTireReplacements * 800) + (this.numberOfPartReplacements * 1500);
    }
}
