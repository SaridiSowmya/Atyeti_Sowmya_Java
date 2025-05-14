package controlstatements;

import java.util.Scanner;

/**Employee Salary Slip Generator
Write a program that takes basic salary as input and calculates:
        - HRA: 20% of basic
- DA: 10% of basic
- PF: 12% of basic
- Gross Salary = Basic + HRA + DA - PF
Generate a formatted salary slip using conditional operators and arithmetic expressions.*/

public class EmployeeSalarySlipGenerator {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("enter the basic salary;");
        double basic=sc.nextDouble();


        double HRA = 0.20 * basic;
        double DA = 0.10 * basic;
        double PF = 0.12 * basic;

        double grossSalary;

        grossSalary = basic + HRA + DA - PF;



        // Generate formatted salary slip
        System.out.println("\n=========== SALARY SLIP ===========");
        System.out.printf("Basic Salary     : %.2f\n", basic);
        System.out.printf("House Rent Allow : %.2f\n", HRA);
        System.out.printf("Dearness Allow   : %.2f\n", DA);
        System.out.printf("Provident Fund   : %.2f\n", PF);
        System.out.println("-----------------------------------");
        System.out.printf("Gross Salary     : %.2f\n", grossSalary);
        System.out.println("===================================");

        sc.close();
    }
}









