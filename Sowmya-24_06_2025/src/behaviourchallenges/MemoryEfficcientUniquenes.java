package behaviourchallenges;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class MemoryEfficcientUniquenes {
        public static int countUnique(int total) {
            Set<Integer> unique = new HashSet<>();

            for (int i = 0; i < total; i++) {
                int value = i % 1000;
                unique.add(value);
            }

            return unique.size();
        }

        public static void main(String[] args) {
            int uniqueCount = countUnique(100_000_000);
            System.out.println("Approx unique values: " + uniqueCount);
        }

}


