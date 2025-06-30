package arraylistnull;

import java.util.ArrayList;
import java.util.List;


public class ArrayListNullTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Adding null values
        list.add(null);
        list.add("Java");
        list.add(null);
        list.add("Python");
        list.add(null);

        System.out.println("List: " + list);

        // Test contains(null)
        System.out.println("Contains null? " + list.contains(null));

        // Test indexOf(null)
        System.out.println("Index of first null: " + list.indexOf(null));

        // Test lastIndexOf(null)
        System.out.println("Last index of null: " + list.lastIndexOf(null));

        // Test remove(null) - removes first null
        boolean removed = list.remove(null);
        System.out.println("Removed null? " + removed);
        System.out.println("List after removing first null: " + list);

        // Count total nulls
        long nullCount = list.stream().filter(e -> e == null).count();
        System.out.println("Total nulls remaining: " + nullCount);
    }
}




