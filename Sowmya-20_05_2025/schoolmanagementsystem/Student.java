package schoolmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person{

    private List<String> grades;
    private Map<String, Boolean> attendance;

    public Student(String name, String address) {
        super(name, address);
        grades = new ArrayList<>();
        attendance = new HashMap<>();
    }

    public void addGrade(String grade)
    {
        grades.add(grade);
    }

    public void markAttendance(String date, boolean present) {
        attendance.put(date, present);
    }

    public void updateRecord(String grade) {
        addGrade(grade);
    }

    public void updateRecord(String date, boolean present) {
        markAttendance(date, present);
    }

    @Override
    public String toString() {
        return super.toString() + "\nGrades: " + grades + "\nAttendance: " + attendance;
    }
}
