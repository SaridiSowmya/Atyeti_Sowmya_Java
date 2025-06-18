package immutablelist;
import java.util.*;

public class ImmutableListConversion {
    public static void main(String[] args){
        List<String> original = new ArrayList<>();
        original.add("Java");
        original.add("Python");


        List<String> unmodifiable1 = Collections.unmodifiableList(original);


        List<String> unmodifiable2 = List.copyOf(original);

        System.out.println("Original: " + original);
        System.out.println("Unmodifiable1 (via Collections): " + unmodifiable1);
        System.out.println("Unmodifiable2 (via List.copyOf): " + unmodifiable2);


        try {
            unmodifiable1.add("C++");
        } catch (Exception e) {
            System.out.println("Exception on unmodifiable1.add(): " + e);
        }

        try {
            unmodifiable2.add("perl");
        } catch (Exception e) {
            System.out.println("Exception on unmodifiable2.add(): " + e);
        }

        original.add("Go");
        System.out.println("After modifying original list:");
        System.out.println("Original: " + original);
        System.out.println("Unmodifiable1: " + unmodifiable1);
        System.out.println("Unmodifiable2: " + unmodifiable2);
    }
}




