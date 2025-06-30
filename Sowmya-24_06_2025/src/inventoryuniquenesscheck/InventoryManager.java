package inventoryuniquenesscheck;
import java.util.LinkedHashSet;
import java.util.Set;

public class InventoryManager {

        private final Set<String> itemCodes = new LinkedHashSet<>();

        public boolean addItem(String code) {
            if (itemCodes.contains(code)) {
                System.out.println("Duplicate code rejected: " + code);
                return false;
            }
            itemCodes.add(code);
            System.out.println("Code added: " + code);
            return true;
        }

        public void printInventory() {
            System.out.println("\nUnique Inventory Codes:");
            itemCodes.forEach(System.out::println);
        }

        public void resetInventory() {
            itemCodes.clear();
            System.out.println("Inventory reset.");
        }
}


