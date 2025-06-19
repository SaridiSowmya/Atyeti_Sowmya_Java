package library;
import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {

        // Step 1: Create the library map
        Map<String, List<String>> library = new HashMap<>();

        // Step 2: Add borrowers
        addBorrower(library, "B101", "Alice");
        addBorrower(library, "B101", "Bob");
        addBorrower(library, "B102", "Charlie");
        addBorrower(library, "B101", "David");
        addBorrower(library, "B103", "Eve");

        // Step 3: Print all book-borrower records
        printLibrary(library);
    }

    // Method to add a borrower to a book
    static void addBorrower(Map<String, List<String>> library, String bookId, String borrower) {
        library.computeIfAbsent(bookId, k -> new ArrayList<>()).add(borrower);
    }

    // Method to display all book-borrower mappings
    static void printLibrary(Map<String, List<String>> library) {
        for (Map.Entry<String, List<String>> entry : library.entrySet()) {
            String bookId = entry.getKey();
            List<String> borrowers = entry.getValue();

            System.out.println(" Book ID: " + bookId);
            if (borrowers.isEmpty()) {
                System.out.println("   No borrowers yet.");
            } else {
                borrowers.forEach(borrower -> System.out.println("   Borrower: " + borrower));
            }
        }
    }
}



