package com.drthisguy;

import java.util.InputMismatchException;
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

    public static float readInNumbOfYears() {
        //New scanner and negative value initiator for years are used for validation.
        Scanner input = new Scanner(System.in);
        float years = -1;
        try {
            while (true) {
                System.out.print("For how many years do you intend to own this vehicle? ");
                years = input.nextFloat();
                if (years > 0)
                    break;
                System.out.println("Please enter a positive value: ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Must enter a numeric value: ");
        } finally {
            return years;
        }
    }

}
