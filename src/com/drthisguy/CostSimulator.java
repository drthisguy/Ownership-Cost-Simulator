package com.drthisguy;

public class CostSimulator {

    public static void main(String[] args) {
        var car = new Car(4, 10, false);
        float numberOfMiles;
        int carType;

        do{
            carType = Console.selectCar();
        } while (carType == -1);
        do {
            //Estimated miles driven per year
            numberOfMiles = Console.readInNumbOfYears() * 15_000;
        } while (numberOfMiles == -15_000);

        switch (carType) {
            case 1:
                break;
            case 2:
                car = new Car(6, 15, false);
                break;
            case 3:
                car = new Car(6, 20, true);
                break;
            case 4:
                car = new Car(8, 25, true);
                break;
            default:
                System.out.println("Have a great day.");
                System.exit(0);
        }
        car.run(numberOfMiles);
    }

}
