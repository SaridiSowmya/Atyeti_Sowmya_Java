package mediumproblems;
import java.util.Stack;


public class QueueStackImplementation {
    private final Stack<Integer> stackIn = new Stack<>();
    private final Stack<Integer> stackOut = new Stack<>();


    public void push(int x) {
        stackIn.push(x);
    }


    public int pop() {
        shiftStacks();
        return stackOut.pop();
    }

    public int peek() {
        shiftStacks();
        return stackOut.peek();
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueStackImplementation queue = new QueueStackImplementation();
        queue.push(10);
        queue.push(20);
        System.out.println(queue.peek());
        queue.push(30);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
    }
}


