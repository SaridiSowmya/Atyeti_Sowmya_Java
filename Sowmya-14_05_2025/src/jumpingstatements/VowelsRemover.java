package jumpingstatements;

//Write a method that removes all vowels from a string using continue.

public class VowelsRemover {
    public static void main(String[] args) {

        String input = "Hello World";
        String result = removeVowels(input);
        System.out.println("Without vowels: " + result);
    }

    public static String removeVowels(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                continue;
            }

            result += ch;
        }

        return result;
    }
}

