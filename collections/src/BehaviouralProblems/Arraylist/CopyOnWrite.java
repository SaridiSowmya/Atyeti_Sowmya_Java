package BehaviouralProblems.Arraylist;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CopyOnWrite {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Thread iteratorThread = new Thread(() -> {
            for (String lang : list) {
                System.out.println("Reading: " + lang);
                try { Thread.sleep(100);
                } catch (Exception ignored) {}
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


//CopyOnWriteArrayList gives a snapshot iterator.

//Any modification creates a new copy of the array, so the iterator sees the old, unmodified version.