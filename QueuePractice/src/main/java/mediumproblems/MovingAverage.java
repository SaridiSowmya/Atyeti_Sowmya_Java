package mediumproblems;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private final int size;
    private final Queue<Integer> window;
    private double sum;

    public MovingAverage(int size) {
        this.size = size;
        this.window = new LinkedList<>();
        this.sum = 0.0;
    }

    public double next(int val) {

        window.offer(val);
        sum += val;


        if (window.size() > size) {
            int removed = window.poll();
            sum -= removed;
        }


        return sum / window.size();
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }
}


