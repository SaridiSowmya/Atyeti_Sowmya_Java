package concurrentadd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class IteratorFailureDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println("Reading: " + value);

            if (value.equals("B")) {
                list.add("X");
            }
        }
    }
}
