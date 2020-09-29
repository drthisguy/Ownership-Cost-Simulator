package com.drthisguy;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private List<CarPart> parts = new ArrayList<>();

    public Car(int numberOfCylinders, int tankSize, boolean hasPremiumWheels) {
        Engine engine = new Engine(numberOfCylinders);
        FuelTank fuelTank = new FuelTank(tankSize);
        Wheels wheels = new Wheels(hasPremiumWheels);

        Collections.addAll(this.parts, engine, fuelTank, wheels);
    }

    public void run(float miles) {
        System.out.println("You've driven a total of " + miles + ".\n");

        for (CarPart part: parts) {
            part.function(miles);
        }
        int totalCost = parts.stream()
                        .map(CarPart::status)
                        .reduce(0, Integer::sum);

        System.out.println("\nYour total cost of ownership so far: " + currency.format(totalCost));
    }
}
