package set.intermediate;
import java.util.*;


import java.util.LinkedHashSet;
import java.util.Set;

public class FirstNonRepeatingElement {
    public static Integer findFirstNonRepeating(int[] arr) {
            Set<Integer> repeating = new HashSet<>();
            Set<Integer> nonRepeating = new LinkedHashSet<>();

            for (int num : arr) {
                if (repeating.contains(num))
                    continue;
                if (nonRepeating.contains(num)) {
                    nonRepeating.remove(num);
                    repeating.add(num);
                } else {
                    nonRepeating.add(num);
                }
            }

            return nonRepeating.isEmpty() ? null : nonRepeating.iterator().next();
        }

        public static void main(String[] args) {
            int[] arr = {4, 5, 1, 2, 0, 4, 5, 1};
            System.out.println("First non-repeating: " + findFirstNonRepeating(arr));
        }
    }
