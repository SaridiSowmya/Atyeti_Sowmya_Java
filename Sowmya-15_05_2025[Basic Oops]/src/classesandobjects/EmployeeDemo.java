package classesandobjects;

public class EmployeeDemo {
    public static void main(String[] args) {
        {
            EmployeeData e1 = new EmployeeData();
            e1.setEmployeeData(111, "sowmya", 20000);
            e1.calculateEmployeeGrade();
            System.out.println(e1);
        }
    }
}
