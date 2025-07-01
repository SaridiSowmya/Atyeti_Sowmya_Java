package classesandobjects;

public class EmployeeData {


    private int employeeNumber;
    private String employeeName;
    private double employeeSalary;
    private char employeeGrade;

    public void setEmployeeData(int eno, String name, double salary)
    {
        employeeNumber = eno;
        employeeName = name;
        employeeSalary = salary;
    }

    @Override
    public String toString()
    {
        return "Employee [employeeNumber=" + employeeNumber + ", employeeName=" + employeeName + ", employeeSalary="
                + employeeSalary + ", employeeGrade=" + employeeGrade + "]";
    }

    public void calculateEmployeeGrade()
    {
        if(employeeSalary >= 100000)
            employeeGrade = 'A';
        else if(employeeSalary >= 75000)
            employeeGrade = 'B';
        else if(employeeSalary >= 50000)
            employeeGrade = 'C';
        else
            employeeGrade = 'D';
    }

}

