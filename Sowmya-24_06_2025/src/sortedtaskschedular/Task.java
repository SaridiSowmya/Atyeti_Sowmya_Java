package sortedtaskschedular;
import java.util.Objects;

public class Task {
        private final int id;
        private final String description;
        private final int priority;

        public Task(int id, String description, int priority) {
            this.id = id;
            this.description = description;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }
        public String getDescription() {
            return description;
        }
        public int getPriority() {
            return priority;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Task)) return false;
            Task task = (Task) o;
            return id == task.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "[" + id + "] - " + description + " (P" + priority + ")";
        }
}

