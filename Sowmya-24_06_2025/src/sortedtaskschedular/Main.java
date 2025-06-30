package sortedtaskschedular;

public class Main {
        public static void main(String[] args) {
            Schedular schedular = new Schedular();

            schedular.addTask(new Task(1, "Fix bug", 2));
            schedular.addTask(new Task(2, "Write tests", 3));
            schedular.addTask(new Task(3, "Deploy system", 5));
            schedular.addTask(new Task(1, "Fix bug", 2));

            schedular.showTasks();
        }
}


