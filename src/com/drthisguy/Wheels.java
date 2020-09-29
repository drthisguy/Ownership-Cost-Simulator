package com.drthisguy;

public class Wheels extends CarPart {
    private final boolean isPremium;
    private double tireTread;
    private int numberOfReplacementTires = 0;


    public Wheels(boolean isPremium) {
        super(75_000);
        this.isPremium = isPremium;
        tireTread = this.isPremium ? 30_000 : 22_500;
    }

    @Override
    public void function(float miles) {
        for (int i = 0; i < miles; i++) {
            this.tireTread--;
                if(tireTread == 0) {
                    this.numberOfReplacementTires++;
                    this.tireTread = isPremium ? 30_000 : 22_500; //tire tread based on quality.
                }
            this.setDurability(this.getDurability() - (this.isPremium ? 1 : 1.25)); //part wear based on part quality.
                if(this.getDurability() <= 0) {
                    setNumberOfReplacementParts(getNumberOfReplacementParts() + 1);
                    this.setDurability(75_000);
                }
        }
    }

    @Override
    public int status() {
        boolean hasTread =this.tireTread > (tireTread/3);
        String message =  hasTread ? "are looking good" : "have low, tread";
        if (this.getDurability() < 22_500)
            message += hasTread ?" However," : "And" +
                    " your " + (this.isPremium ? "premium " : "") + "wheels are beginning to fail.";

        System.out.println("Currently, your " + (this.isPremium ? "premium " : "") + "tires " + message);
        System.out.println("You've replaced your tires "+ this.numberOfReplacementTires + " time(s).");
        System.out.println("And you've replaced the wheels "+ this.getNumberOfReplacementParts() + " time(s).");

        return (this.numberOfReplacementTires * 800) + (this.getNumberOfReplacementParts() * 1500);
    }

}
