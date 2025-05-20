package schoolmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{

    private List<String> subjects;


    public Teacher(String name, String address) {
        super(name, address);
        subjects =new ArrayList<>();
    }

    public void addSubjects(String subject)
    {
        subjects.add(subject);
    }

    public void updateSubject(String subject) {
        addSubjects(subject);
    }

    @Override
    public String toString() {
        return super.toString() + "\nSubjects Taught: " + subjects;
    }
}
