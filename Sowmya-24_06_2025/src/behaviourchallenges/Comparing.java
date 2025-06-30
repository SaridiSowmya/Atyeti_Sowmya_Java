package behaviourchallenges;
import java.util.*;


public class Comparing {
        public static void main(String[] args) {
            List<Integer> input = Arrays.asList(5, 3, 9, 1, 7);

            Set<Integer> hashSet = new HashSet<>(input);
            Set<Integer> linkedHashSet = new LinkedHashSet<>(input);
            Set<Integer> treeSet = new TreeSet<>(input);

            System.out.println("HashSet: " + hashSet);//unordered
            System.out.println("LinkedHashSet: " + linkedHashSet);//insertionorer
            System.out.println("TreeSet: " + treeSet);//sortedorder
        }
}



