package advancelevel;
import java.util.*;

public class Anagram {
    public static Map<String, Set<String>> groupAnagrams(List<String> words) {
        Map<String, Set<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new HashSet<>()).add(word);
        }

        return map;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "art", "dog");
        Map<String, Set<String>> grouped = groupAnagrams(words);

        for (Set<String> group : grouped.values()) {
            if (group.size() > 1)
                System.out.println("Anagram group: " + group);
        }
    }
}


