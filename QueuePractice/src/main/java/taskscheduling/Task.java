package taskscheduling;

public class Task implements Comparable<Task> {
    private final String name;
    private final int priority;
    private final long createdAt;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.createdAt = System.nanoTime();
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void execute() {
        System.out.println(" Executing Task: " + name + " [Priority: " + priority + "]");
    }

    @Override
    public int compareTo(Task other) {
        int cmp = Integer.compare(this.priority, other.priority);
        if (cmp == 0) {
            return Long.compare(this.createdAt, other.createdAt);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "Task{" + name + ", priority=" + priority + "}";
    }
}


