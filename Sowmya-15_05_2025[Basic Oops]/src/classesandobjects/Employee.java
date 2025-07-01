package classesandobjects;

public class Employee {
        int empId;
        String empName;

        public void setStudentData()
        {
            empId = 111;
            empName = "david";
        }

        public void showStudentData()
        {
            System.out.println(empId);
            System.out.println(empName);
        }

        public static void main(String[] args)
        {
            Employee e = new Employee();
            //  e.showStudentData();

            e.setStudentData();
            e.showStudentData();
        }

    }

