package employeedepartdashboard;
import java.util.*;
import java.util.stream.*;

public class DepartDashBoard {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("sowmya", "IT", "John", 95000),
                new Employee("Bob", "IT", "John", 85000),
                new Employee("Charlie", "IT", "Susan", 87000),
                new Employee("David", "Finance", "Mary", 92000),
                new Employee("rahul", "Finance", "Mary", 97000),
                new Employee("seetha", "Finance", "Alex", 88000),
                new Employee("Grace", "HR", "Nina", 60000),
                new Employee("Harish", "HR", "Nina", 63000),
                new Employee("Iyan", "HR", "Nina", 62000)
        );


        Map<String, Map<String, List<Employee>>> deptMgrGrouping = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getManager)));

        System.out.println("=== Employees Grouped by Department → Manager ===");
        deptMgrGrouping.forEach((dept, mgrMap) -> {
            System.out.println("Department: " + dept);
            mgrMap.forEach((mgr, empList) -> {
                System.out.println("  Manager: " + mgr);
                empList.forEach(emp -> System.out.println("    " + emp.getName() + " - $" + emp.getSalary()));
            });
        });


        Map<String, Map<String, Double>> avgSalaryPerManager = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getManager,
                                Collectors.averagingDouble(Employee::getSalary))));

        System.out.println("\n=== Average Salary by Department → Manager ===");
        avgSalaryPerManager.forEach((dept, mgrMap) -> {
            System.out.println("Department: " + dept);
            mgrMap.forEach((mgr, avg) ->
                    System.out.printf("  Manager: %s -> Avg Salary: $%.2f%n", mgr, avg));
        });


        Map<String, Double> budgetPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        System.out.println("\n=== Department Budgets ===");
        budgetPerDept.forEach((dept, budget) ->
                System.out.printf("%-10s -> $%.2f%n", dept, budget));


        Map.Entry<String, Double> topDept = budgetPerDept.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println("\n Department with Highest Budget:");
        System.out.printf("%s -> $%.2f%n", topDept.getKey(), topDept.getValue());
    }
}





