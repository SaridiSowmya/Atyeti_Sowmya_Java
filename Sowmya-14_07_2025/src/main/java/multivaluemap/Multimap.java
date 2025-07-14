package multivaluemap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Multimap {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("sowmya", "CS", "Engineering", "Dr.ramam"),
                new Student("Bob", "ECE", "Engineering", "Dr. ramesh"),
                new Student("Charlie", "CS", "Engineering", "Dr. Smith"),
                new Student("David", "Math", "Science", "Dr. Lee"),
                new Student("ramesh", "ECE", "Engineering", "Dr. Jones"),
                new Student("mahesh", "Math", "Science", "Dr. Lee"),
                new Student("dravid", "CS", "Engineering", "Dr. rao")
        );

        GroupingService service = new GroupingService();

        System.out.println("\n Grouped by Department:");
        service.printGrouped(service.groupByDept(students));

        System.out.println("\n Grouped by College:");
        service.printGrouped(service.groupByCollege(students));

        System.out.println("\n Grouped by Advisor:");
        service.printGrouped(service.groupByAdvisor(students));
    }
}



