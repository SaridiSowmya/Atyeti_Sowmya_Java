package studentrecordmanagementsystem;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        try {
            manager.loadFromFile();
        } catch (Exception e) {
            System.out.println("Couldn't load file: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n1. Add Student\n2. Edit Student\n3. Delete Student\n4. List Students");
            System.out.println("5. Sort by Name\n6. Sort by Marks\n0. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Roll No: "); String roll = sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        int[] marks = new int[3];
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Mark " + (i + 1) + ": ");
                            marks[i] = sc.nextInt();
                        }
                        sc.nextLine();
                        manager.addStudent(new Student(roll, name, marks));
                    }
                    case 2 -> {
                        System.out.print("Roll No to edit: "); String roll = sc.nextLine();
                        System.out.print("New Name: "); String name = sc.nextLine();
                        int[] marks = new int[3];
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Mark " + (i + 1) + ": ");
                            marks[i] = sc.nextInt();
                        }
                        sc.nextLine();
                        manager.editStudent(roll, name, marks);
                    }
                    case 3 -> {
                        System.out.print("Roll No to delete: "); String roll = sc.nextLine();
                        manager.deleteStudent(roll);
                    }
                    case 4 -> manager.listStudents();
                    case 5 -> {
                        manager.sortByName();
                        System.out.println("Sorted by name:");
                        manager.listStudents();
                    }
                    case 6 -> {
                        manager.sortByTotalMarks();
                        System.out.println("Sorted by total marks:");
                        manager.listStudents();
                    }
                    case 0 -> {
                        manager.saveToFile();
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
