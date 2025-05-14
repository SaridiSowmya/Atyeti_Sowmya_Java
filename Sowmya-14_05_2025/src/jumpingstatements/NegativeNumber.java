package jumpingstatements;
//Create a method checkNegative(int[] nums) that prints "Negative found"
// and returns immediately when it finds a negative number.
// Otherwise, it should print "All numbers are positive".

public class NegativeNumber {
    public static void main(String[] args) {

        int[] numbers = {4, 2, -5, 7};

         checkNegative(numbers);


    }

    public static void checkNegative(int[] nums) {
        for (int num : nums) {
            if (num < 0) {
                System.out.println("Negative found");
                return;
            }
        }
        System.out.println("All numbers are positive");
    }
}











