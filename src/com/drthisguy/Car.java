package com.drthisguy;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private final NumberFormat currency;
    private List<CarPart> parts = new ArrayList<>();

    public Car(int numberOfCylinders, int tankSize, boolean hasPremiumWheels) {
        this.currency = NumberFormat.getCurrencyInstance();
        Engine engine = new Engine(numberOfCylinders);
        FuelTank fuelTank = new FuelTank(tankSize);
        Wheels wheels = new Wheels(hasPremiumWheels);

        Collections.addAll(this.parts, engine, fuelTank, wheels);
    }

    public void run(float miles) {
        System.out.println("vroom vroom!\n");

        for (CarPart part: parts) {
            part.function(miles);
            part.status();
        }
        int totalCost = parts.stream()
                        .map(x -> x.getOwnershipCost())
                        .reduce(0, (a, b) -> a + b);

        System.out.println("\nTotal cost of ownership so far: " + currency.format(totalCost));
    }
}
