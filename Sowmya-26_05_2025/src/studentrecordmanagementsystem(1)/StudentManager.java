package studentrecordmanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.csv";

    public void loadFromFile() throws IOException {
        students.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String roll = parts[0];
                String name = parts[1];
                int[] marks = { Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]) };
                students.add(new Student(roll, name, marks));
            }
        }
    }

    public void saveToFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        }
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void deleteStudent(String roll) {
        students.removeIf(s -> s.getRollNo().equals(roll));
    }

    public void editStudent(String roll, String newName, int[] newMarks) {
        for (Student s : students) {
            if (s.getRollNo().equals(roll)) {
                s.setName(newName);
                s.setMarks(newMarks);
                break;
            }
        }
    }

    public void listStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public void sortByTotalMarks() {
        students.sort((a, b) -> Integer.compare(b.getTotal(), a.getTotal()));
    }
}
