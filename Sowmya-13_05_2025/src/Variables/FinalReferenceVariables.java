package Variables;

public class FinalReferenceVariables {

    private final int[] arr ={1,2,3,4,5};

    public void modifyArray() {
        arr[0] = 10; // allowed: modifying contents
        arr[1] = 20;
    }

    public void printArray() {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FinalReferenceVariables example = new FinalReferenceVariables();
        System.out.println("before the array modified:");
        example.printArray();       // Output: 1 2 3
       example.modifyArray();
        System.out.println("after the array modified:");
        example.printArray();       // Output: 10 20 3
    }
}


