package behaviourchallenges;
import java.util.*;

public class ImmutableSet {
    public static void main(String[] args) {
        Set<String> constants = Set.of("A", "B", "C");

        System.out.println("Immutable Set: " + constants);

        // Try modifying
        try {
            constants.add("D"); // Throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable set: " + e);
        }
    }

}


