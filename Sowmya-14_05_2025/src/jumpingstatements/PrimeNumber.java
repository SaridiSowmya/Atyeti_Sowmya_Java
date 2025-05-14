package jumpingstatements;

//Write a Java program that takes an array of integers
// and prints each element until a prime number is found.
// Once a prime is found, stop printing.

public class PrimeNumber {
    public static void main(String[] args) {

        int[] numbers = {4, 6, 8, 9, 11, 14, 15};


        for (int num : numbers) {
            if (isPrime(num)) {
                break;
            }
            System.out.print(num + " ");
        }
    }


    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}



