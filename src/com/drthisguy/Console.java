package com.drthisguy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static int selectCar() {
        var input = new Scanner(System.in);
        int selection = -1;

        System.out.println("\n1 - Subcompact Hatchback");
        System.out.println("2 - Mid-sized Coupe");
        System.out.println("3 - Full-sized Sedan");
        System.out.println("4 - Truck or SUV");
        System.out.println("5 - Quit");
        System.out.println("\n-------------------------");

        try {
            while(true) {
                System.out.print("Choose the type of car, for which you wish to simulate ownership cost: ");
                selection = input.nextInt();
                if (selection <= 5 && selection > 0) {
                    break;
                }
                System.out.println("Please select a valid menu item from 1 to 5.");
            }
        } catch (InputMismatchException e) {
            System.out.println("You must select an integer value between 1 and 5.");
        } finally {
            return selection;
        }
    }

    public static float readInNumbOfYears() {
        //New scanner and negative value initiator for years are used for validation.
        var input = new Scanner(System.in);
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
            //noinspection ReturnInsideFinallyBlock
            return years;
        }
    }

}
