package concurrentadd;
import java.util.ArrayList;
import java.util.List;


public class IndexIterationDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Before iteration: " + list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at " + i + ": " + list.get(i));

            if (list.get(i).equals("B")) {
                list.add("X");
                list.add(i + 1, "Y");
            }
        }

        System.out.println("After iteration: " + list);
    }
}



