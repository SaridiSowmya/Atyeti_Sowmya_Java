package advancelevel;
import java.util.*;

public class UniqueEmail {
    public static int countUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replace(".", "");
            String domain = parts[1];
            seen.add(local + "@" + domain);
        }

        return seen.size();
    }

    public static void main(String[] args) {
        String[] emails = {
                "test.email+alex@gmail.com",
                "test.e.mail+bob@gmail.com",
                "testemail@gmail.com",
                "user@yahoo.com"
        };

        System.out.println("Unique emails: " + countUniqueEmails(emails));
    }

}


