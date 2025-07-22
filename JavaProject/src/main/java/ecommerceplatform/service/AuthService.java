package ecommerceplatform.service;
import ecommerceplatform.model.User;

import java.io.*;
import java.util.*;

public class AuthService {
    private static final String USER_FILE = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\JavaProject\\src\\main\\java\\ecommerceplatform\\data\\users.csv";
    private static List<User> users = new ArrayList<>();

    static {
        loadUsers();
    }

    private static void loadUsers() {
        users.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String username = parts[1];
                String password = parts[2];
                User.Role role = User.Role.valueOf(parts[3]);
                users.add(new User(id, username, password, role));
            }
        } catch (IOException e) {
            System.out.println("User file loading failed: " + e.getMessage());
        }
    }

    public static User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public static void register(String username, String password, User.Role role) {
        int id = users.size() + 1;
        User newUser = new User(id, username, password, role);
        users.add(newUser);
        saveUserToFile(newUser);
    }

    private static void saveUserToFile(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getRole());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing user: " + e.getMessage());
        }
    }
}



