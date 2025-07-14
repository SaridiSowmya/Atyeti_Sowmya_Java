package loggingsystem;
import java.util.IdentityHashMap;


public class IdentityLoginTracker {
    private final IdentityHashMap<User, Boolean> loggedInUsers = new IdentityHashMap<>();

    public boolean login(User user) {
        if (loggedInUsers.containsKey(user)) {
            System.out.println("Login rejected for " + user + " (Already logged in with this object)");
            return false;
        } else {
            loggedInUsers.put(user, true);
            System.out.println("Logged in: " + user);
            return true;
        }
    }

    public void logout(User user) {
        if (loggedInUsers.remove(user) != null) {
            System.out.println("Logged out: " + user);
        } else {
            System.out.println("Logout failed (user not logged in): " + user);
        }
    }

    public void printAll() {
        System.out.println("\n Currently logged-in objects:");
        for (User u : loggedInUsers.keySet()) {
            System.out.println(" " + u + " [objectRef: " + System.identityHashCode(u) + "]");
        }
    }
}
