import java.util.*;

public class MinStack {
    private Stack<Integer> myStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push (int val) {
        myStack.push(val);
        if (minStack.empty()) minStack.push(val);
        else {
            if(minStack.peek() >= val) { minStack.push(val); }
        }
        printStackAndMin();
    }

    public int pop(){
        if (Objects.equals(myStack.peek(), minStack.peek())) minStack.pop();
        int returnVal = myStack.pop();
        printStackAndMin();
        return returnVal;
    }
    public int peek(){
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private void printStackAndMin(){
        System.out.println("Current Stack (bottom to top): " + Arrays.toString(myStack.toArray()));
        System.out.println("Min: " + this.getMin() + "\n");
    }

    public static void main(String[] args)
    {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(2);
        minStack.pop();
        minStack.push(100);
        minStack.push(1);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(-2);
        minStack.push(2);
        minStack.push(50);
        minStack.push(-10);
        minStack.pop();
    }
}
