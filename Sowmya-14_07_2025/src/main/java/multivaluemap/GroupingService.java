package multivaluemap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingService {
    public Map<String, List<Student>> groupByDept(List<Student> students) {
        Map<String, List<Student>> grouped = new HashMap<>();
        for (Student s : students) {
            grouped.computeIfAbsent(s.getDepartment(), k -> new ArrayList<>()).add(s);
        }
        return grouped;
    }

    public Map<String, List<Student>> groupByCollege(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCollege));
    }

    public Map<String, List<Student>> groupByAdvisor(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getAdvisor));
    }


    public <K> Map<K, List<Student>> groupByField(List<Student> students, Function<Student, K> classifier) {
        return students.stream().collect(Collectors.groupingBy(classifier));
    }

    public void printGrouped(Map<String, List<Student>> grouped) {
        grouped.forEach((k, v) -> {
            System.out.println(" " + k + ": " + v);
        });
    }
}





