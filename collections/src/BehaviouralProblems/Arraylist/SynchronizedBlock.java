package BehaviouralProblems.Arraylist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedBlock {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Thread iteratorThread = new Thread(() -> {
            synchronized (list) {
                for (String lang : list) {
                    System.out.println("Reading: " + lang);
                    try { Thread.sleep(100); } catch (Exception ignored) {}
                }
            }
        });

        Thread modifierThread = new Thread(() -> {
            try {
                Thread.sleep(150);
                list.add("C");
                System.out.println("Added C to list");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iteratorThread.start();
        modifierThread.start();
    }
}

//You synchronize manually to ensure that iteration and modification don’t overlap.

//Safe but less flexible and may block other threads unnecessarily.
