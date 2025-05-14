package jumpingstatements;


//Write a Java program that prints numbers from 1 to 50,
// but skips numbers that are multiples of 3.


public class SkipMuliplesOfThree {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            // Skip if the number is a multiple of 3
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}


