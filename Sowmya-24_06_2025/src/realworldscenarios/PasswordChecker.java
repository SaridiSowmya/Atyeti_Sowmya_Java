package realworldscenarios;
import java.util.*;

public class PasswordChecker {
    private final LinkedHashSet<String> history = new LinkedHashSet<>();
    private final int maxSize = 5;

    public boolean setPassword(String newPassword) {
        if (history.contains(newPassword)) {
            System.out.println("Password reuse not allowed!");
            return false;
        }
        if (history.size() == maxSize) {
            Iterator<String> it = history.iterator();
            it.next();
            it.remove(); // remove oldest
        }
        history.add(newPassword);
        return true;
    }

    public static void main(String[] args) {
        PasswordChecker ph = new PasswordChecker();
        ph.setPassword("pass1");
        ph.setPassword("pass2");
        ph.setPassword("pass3");
        ph.setPassword("pass4");
        ph.setPassword("pass5");
        ph.setPassword("pass6"); // removes pass1
        ph.setPassword("pass3");
        System.out.println("Password history: " + ph.history);
    }

}


