package schoolmanagementsystem;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        Student s1 = new Student("sowmya","vizag");
        s1.updateRecord("A");
        s1.updateRecord("2025-05-20", true);
        students.add(s1);


        Student s2 = new Student("someswari","vizag");
        s2.updateRecord("A");
        s2.updateRecord("2025-05-20", true);
        students.add(s2);

        System.out.println("=== Student Info ===");

        for (Student student : students) {

            System.out.println(student);

        }



//        Teacher t = new Teacher("john", "england");
//        t.updateSubject("Mathematics");

//        Staff staff = new Staff("david", "newyork", "Librarian");
//        staff.updateRecord("Senior Librarian");

       // System.out.println("=== Student Info ===\n");
//        System.out.println("\n=== Teacher Info ===\n" + t);
//        System.out.println("\n=== Staff Info ===\n" + staff);


        List<Teacher> Teacher = new ArrayList<>();

        // Add teacher
        Teacher t1 = new Teacher("cris", "england");
        t1.updateSubject("Mathematics");
        System.out.println("=== Teacher Info ===");
        System.out.println(t1);

        Teacher t2 = new Teacher("david", "newyork");
        t2.updateSubject("physics");
       // System.out.println("=== Teacher Info ===");
        System.out.println(t2);

        // System.out.println("=== Teacher Info ===");


        for (Teacher t : Teacher) {

            System.out.println(t);

        }




        // Add staff
        Staff staff1 = new Staff("Jane", "789 Pine St", "Librarian");
        staff1.updateRecord("Senior Librarian");
        System.out.println("=== Staff Info ===");
        System.out.println(staff1);
    }
}


