package sublist;
import java.util.ArrayList;
import java.util.List;


public class SubList {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("Java");
        originalList.add("Python");
        originalList.add("C++");
        originalList.add("JavaScript");
        originalList.add("Go");

        System.out.println("Original List: " + originalList);

        List<String> subList = originalList.subList(1, 4);
        System.out.println("SubList (1 to 4): " + subList);


        subList.remove("Python");
        subList.add("Rust");
        System.out.println("After modifying subList:");
        System.out.println("SubList: " + subList);
        System.out.println("Original List: " + originalList);


        originalList.add("Kotlin");
        System.out.println("After adding to originalList:");
        System.out.println("Original List: " + originalList);

        try {
            subList.add("TypeScript");
        } catch (Exception e) {
            System.out.println("Exception after modifying original list: " + e);
        }
    }
}


