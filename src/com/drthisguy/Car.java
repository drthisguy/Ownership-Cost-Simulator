package com.drthisguy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private List<CarPart> parts = new ArrayList<>();

    public Car(int numberOfCylinders, int tankSize, boolean hasPremiumWheels) {
        Engine engine = new Engine(numberOfCylinders);
        FuelTank fuelTank = new FuelTank(tankSize);
        Wheels wheels = new Wheels(hasPremiumWheels);

        Collections.addAll(this.parts, engine, fuelTank, wheels);
    }

    public void run(int miles) {
        System.out.println("vroom vroom!\n");

        for (CarPart part: parts) {
            part.function(miles);
            part.status();
        }
        int totalCost = parts.stream()
                        .map(x -> x.getOwnershipCost())
                        .reduce(0, (a, b) -> a + b);

        System.out.println("Total cost of ownership so far: " + totalCost);
    }
}
