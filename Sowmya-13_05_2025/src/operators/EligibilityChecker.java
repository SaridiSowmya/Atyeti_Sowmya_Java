package operators;

import java.util.Scanner;
//relational and logical




//Eligibility Checker
//Check if a person is eligible for a loan based on:
//
//Age > 21
//
//Salary > 25,000
//
//Not having any pending loans
//Use logical (&&, !) and relational operators.
public class EligibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Enter your monthly salary: ");
        double salary = scanner.nextDouble();




        boolean isEligible = (age > 21) || (salary > 25000);


        if (isEligible) {
            System.out.println("You are eligible for a loan.");
        } else {
            System.out.println("You are NOT eligible for a loan.");
        }
        scanner.close();
    }
}

