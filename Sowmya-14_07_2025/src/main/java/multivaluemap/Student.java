package multivaluemap;

public class Student {
    private final String name;
    private final String department;
    private final String college;
    private final String advisor;

    public Student(String name, String department, String college, String advisor) {
        this.name = name;
        this.department = department;
        this.college = college;
        this.advisor = advisor;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getCollege() {
        return college;
    }

    public String getAdvisor() {
        return advisor;
    }

    @Override
    public String toString() {
        return name;
    }
}



