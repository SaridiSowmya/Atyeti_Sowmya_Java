package inheritance;

public class Manager extends Employee{
    String department;

    public Manager(String name, int id, double salary,String department) {
        super(name,id,salary);
        this.department = department;
    }

    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("Department: $" + department);
    }


}


