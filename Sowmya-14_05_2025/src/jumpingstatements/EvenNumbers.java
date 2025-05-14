package jumpingstatements;

public class EvenNumbers {
    public static void main(String[] args) {
        for (int num = 2; ; num += 2) {
            if (num >= 10) {
                break;
            }
            System.out.print(num + " ");
        }
    }
}


