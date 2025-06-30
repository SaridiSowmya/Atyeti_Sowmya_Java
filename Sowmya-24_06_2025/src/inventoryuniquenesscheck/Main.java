package inventoryuniquenesscheck;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter item codes (type 'done' to finish):");

        while (true) {
            System.out.print("Code: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            if (!input.isEmpty()) {
                manager.addItem(input.toUpperCase());
            }
        }

        manager.printInventory();
    }
}


