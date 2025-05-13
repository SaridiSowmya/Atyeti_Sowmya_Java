package operators;
//Grade Calculator
//Take three subject marks as input. Calculate average and:
//
//Print "Pass" if average >= 40 and no subject is < 35
//
//Otherwise print "Fail"
//Combine relational and logical operators.


import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your maths marks: ");
        int maths = scanner.nextInt();

        System.out.println("Enter your physics marks: ");
        int physics = scanner.nextInt();


        System.out.println("Enter your physics marks: ");
        int chemistry = scanner.nextInt();


        int average = (maths+physics+chemistry)/3;
        System.out.println("the average is:" + average);

        boolean isPass = average >= 40 && maths >= 35 && physics >= 35 && chemistry >= 35;


        if (isPass) {
            System.out.println("You are promoted.");
        } else {
            System.out.println("You are NOT promoted.");
        }
        scanner.close();
    }
}
