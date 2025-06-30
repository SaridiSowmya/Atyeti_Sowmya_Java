package set.intermediate;

import java.util.HashSet;
import java.util.Set;

public class UniqueStudents {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student(101, "sowmya"));
        students.add(new Student(102, "david"));
        students.add(new Student(101, "bob"));

        for (Student s : students) {
            System.out.println(s);
        }
    }
}

