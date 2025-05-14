package controlstatements;

import java.util.Scanner;
/**COVID Vaccination Slot Booking System
Create a program to book vaccine slots:
        - User inputs age and location
- If age < 18, deny booking
- Display available slots per location using switch-case
Use nested conditions and control flow.*/


public class CovidVaccSlotBookingSys {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---------covid vaccination slot booking system-------- ");

        System.out.println("enter the age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("enter your location (hyderabad/vizag/banglore):");
        String location = sc.nextLine();


        if (age < 18) {
            System.out.println("sorry you are not eligible to  vaccination");
        } else {
            System.out.println("you are eligible for vaccination");
            System.out.println("checking available slots in your location");

            switch (location.toLowerCase()) {

                case "hyderabad":
                    System.out.println("Available slots in hyderabad:");
                    System.out.println("- Slot 1: 9:00 AM");
                    System.out.println("- Slot 2: 12:00 PM");
                    System.out.println("- Slot 3: 3:00 PM");
                    break;
                case "vizag":
                    System.out.println("Available slots in vizag:");
                    System.out.println("- Slot 1: 10:00 AM");
                    System.out.println("- Slot 2: 1:00 PM");
                    System.out.println("- Slot 3: 4:00 PM");
                    break;
                case "bangalore":
                    System.out.println("Available slots in Banglore:");
                    System.out.println("- Slot 1: 8:30 AM");
                    System.out.println("- Slot 2: 11:30 AM");
                    System.out.println("- Slot 3: 2:30 PM");
                    break;
                default:
                    System.out.println("Sorry, no data available for this location.");
            }
        }
        sc.close();
    }
}