package realworldscenarios;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        List<Contact> contacts = Arrays.asList(
                new Contact("david", "123"),
                new Contact("sowmya", "456"),
                new Contact("someswari", "123") // duplicate phone
        );

        Set<String> phoneSet = new HashSet<>();
        List<Contact> uniqueContacts = new ArrayList<>();

        for (Contact c : contacts) {
            if (phoneSet.add(c.phone)) {
                uniqueContacts.add(c);
            }
        }

        for (Contact c : uniqueContacts) {
            System.out.println(c);
        }
    }

}

