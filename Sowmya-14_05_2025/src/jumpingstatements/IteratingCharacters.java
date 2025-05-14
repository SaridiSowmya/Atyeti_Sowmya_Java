package jumpingstatements;


//Iterate through characters of a string and print them one by one.
// Stop printing when the character 'x' is found.

public class IteratingCharacters {
    public static void main(String[] args) {

        String text = "Hello, exoplanet";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == 'x') {
                break;
            }

            System.out.print(ch + " ");
        }
    }
}

