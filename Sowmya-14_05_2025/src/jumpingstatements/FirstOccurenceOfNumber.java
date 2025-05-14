package jumpingstatements;

//Write a method that finds the first occurrence of a given
// number in an array. Use break to exit the loop
// after the number is found.
public class FirstOccurenceOfNumber {
    public static void main(String[] args) {
        int []numbers ={10,20,50,30,40,50};
        int target=50;

        int index= findFirstOccurrence(numbers , target);

        if (index != -1) {
            System.out.println("First occurrence of " + target + " is at index: " + index);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
    public static int findFirstOccurrence(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }













