package controlstatements;

import java.util.Scanner;

/**university Grading System
For a student, input marks of 6 subjects. Calculate:
        - Total, average, and grade
- If any subject is failed (<35), overall result is 'FAIL'
Else use average to assign grade (A/B/C/D). Use arrays, loops, and control flow.*/

public class UniversityGradingSystem {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int total=0;
        boolean hasFailed = false;

        System.out.println("enter the total subjects:");
        int n=sc.nextInt();

        for(int i=1;i<=n;i++)
        {
            System.out.println("subject" + i + " : ");
            int marks=sc.nextInt();

            if(marks<35)
            {
                hasFailed =true;

            }

            total+=marks;

        }

        double average = total / 6.0;
        String grade;

        // Determine result
        if (hasFailed) {
            grade = "FAIL";
        } else {
            if (average >= 85) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C";
            } else {
                grade = "D";
            }
        }

        // Output
        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);

        //sc.close();
    }
}











