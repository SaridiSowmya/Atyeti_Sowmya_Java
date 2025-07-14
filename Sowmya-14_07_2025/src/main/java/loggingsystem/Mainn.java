package loggingsystem;

public class Mainn {
    public static void main(String[] args) {
        IdentityLoginTracker tracker = new IdentityLoginTracker();

        User user1 = new User("sowmya");
        User user2 = new User("sowmya");
        User user3 = user1;

        tracker.login(user1);
        tracker.login(user2);
        tracker.login(user3);

        tracker.printAll();

        tracker.logout(user1);
        tracker.logout(user3);
        tracker.logout(user2);
    }
}



