package employeedepartdashboard;

public class Employee {
    private String name;
    private String department;
    private String manager;
    private double salary;

    public Employee(String name, String department, String manager, double salary) {
        this.name = name;
        this.department = department;
        this.manager = manager;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public String getManager() {
        return manager;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " | " + department + " | " + manager + " | $" + salary;
    }
}



