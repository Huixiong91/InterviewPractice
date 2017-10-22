import java.util.*;
public class MyQueue {
    private Stack<Integer> enQueue = new Stack<>();
    private Stack<Integer> deQueue = new Stack<>();

    public void insert(int val) {
        enQueue.push(val);
    }

    public void remove() {
        if (!deQueue.empty()) deQueue.pop();
        else {
            while (!enQueue.empty()) deQueue.push(enQueue.pop());
            if (!deQueue.empty()) deQueue.pop();
        }
    }

    public int peek() {
        if (!deQueue.empty()) return deQueue.peek();
        else {
            while (!enQueue.empty()) deQueue.push(enQueue.pop());
            if (!deQueue.empty()) return deQueue.peek();
        }
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        myQueue.insert(4);
        myQueue.insert(5);
        System.out.println(myQueue.peek());
        myQueue.remove();
        System.out.println(myQueue.peek());
        myQueue.insert(6);
        myQueue.insert(7);
        myQueue.remove();
        System.out.println(myQueue.peek());
        myQueue.remove();
        System.out.println(myQueue.peek());
        myQueue.remove();
        System.out.println(myQueue.peek());
        myQueue.remove();
        System.out.println(myQueue.peek());
        myQueue.remove();
        System.out.println(myQueue.peek());
        myQueue.remove();
        System.out.println(myQueue.peek());

    }
}

