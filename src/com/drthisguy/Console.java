package com.drthisguy;

import java.util.Scanner;

public class Console {

    private static Scanner input = new Scanner(System.in);

    public static int selectCar() {

        System.out.println("\n1 - Subcompact Hatchback");
        System.out.println("2 - Midsized Sedan");
        System.out.println("3 - Truck/SUV");
        System.out.println("4 - Quit");
        System.out.println("\n-------------------------");
        System.out.print("Choose the type of car, for which you wish to simulate ownership cost: ");

        int selection = input.nextInt();
        return selection;
    }

    public static int readInNumbOfMiles () {
        int miles;
        while(true) {
            System.out.print("For how many miles do you intend to own this vehicle? ");
            miles = input.nextInt();
            if(miles >= 0 &&  miles % 1 == 0)
                break;
            System.out.print("Please enter a positive integer for the number of miles: ");
        }
        return miles;
    }
}
