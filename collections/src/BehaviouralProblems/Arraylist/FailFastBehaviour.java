package BehaviouralProblems.Arraylist;

import java.util.ArrayList;
import java.util.List;

public class FailFastBehaviour {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Thread iteratorThread = new Thread(() -> {
            try {
                for (String lang : list) {
                    System.out.println("Reading: " + lang);
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
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

//ArrayList's iterator checks a modCount field.

//When you modify the list structurally like add() or remove(), the modCount changes.

//The iterator notices and throws ConcurrentModificationException.


