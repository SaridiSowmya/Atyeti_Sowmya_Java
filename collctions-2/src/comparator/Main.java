package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("dev", 28, 60000),
                new Employee("Bob", 35, 75000),
                new Employee("david", 25, 50000),
                new Employee("Daniel", 28, 80000)
        );


        employees.sort(Comparator.comparingInt(e -> e.age));
        System.out.println(" Sorted by Age:");
        employees.forEach(System.out::println);


        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        System.out.println("\n Sorted by Salary (Descending):");
        employees.forEach(System.out::println);




    }
}
