package mediumproblems;
import java.util.*;


public class FirstNonRepeatingStream {
    public static void printFirstNonRepeating(String stream) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char ch : stream.toCharArray()) {

            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            queue.offer(ch);

            while (!queue.isEmpty() && freqMap.get(queue.peek()) > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                System.out.print("- ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }
    }
    public static void main(String[] args) {
        String input = "aabcbd";
        System.out.println("Input:  " + input);
        System.out.print("Output: ");
        printFirstNonRepeating(input);
    }
}


