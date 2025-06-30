package sortedtaskschedular;
import java.util.*;

public class Schedular {
        private final Set<Task> taskQueue = new TreeSet<>((t1, t2) -> {
            int cmp = Integer.compare(t2.getPriority(), t1.getPriority());
            if (cmp == 0) return Integer.compare(t1.getId(), t2.getId());
            return cmp;
        });

        public boolean addTask(Task task) {
            boolean added = taskQueue.add(task);
            if (!added) {
                System.out.println("Duplicate task not added: " + task.getDescription());
            }
            return added;
        }

        public void showTasks() {
            System.out.println("\n Current Task Queue:");
            taskQueue.forEach(System.out::println);
        }
}


