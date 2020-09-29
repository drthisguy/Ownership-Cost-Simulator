package com.drthisguy;

public class Simulator {

    public static void main(String[] args) {

        var car = new Car(4, 10, false);

        int carType = Console.selectCar();
        switch (carType) {
            case 1:
                break;
            case 2:
                car = new Car(6, 15, true);
                break;
            case 3:
                car = new Car(8, 20, true);
                break;
            default:
                System.out.println("Have a great day.");
                System.exit(0);
        }
        float numberOfMiles = Console.readInNumbOfYears() * 15_000; //estimated miles driven per year
        car.run(numberOfMiles);
    }
}
