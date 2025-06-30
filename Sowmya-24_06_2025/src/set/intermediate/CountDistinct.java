package set.intermediate;
import java.util.*;

public class CountDistinct {
        public static int countUnique(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
            }
            return set.size();
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 2, 3, 4, 4, 5};
            System.out.println("Distinct count: " + countUnique(arr));
        }
}


