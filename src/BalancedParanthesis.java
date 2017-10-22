import java.util.*;
public class BalancedParanthesis {

    private static boolean isBalanced(String input) {
        Stack<Character> myStack = new Stack<Character>();
        for (char c : input.toCharArray()) {
            if (c == '{')  myStack.push('}');
            else if (c == '[') myStack.push(']');
            else if (c == '(') myStack.push(')');
            else {
                if (myStack.isEmpty() || c != myStack.peek()) return false;
                myStack.pop();
            }
        }
        return (myStack.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(()))")); // false
        System.out.println(isBalanced("(())")); // true
        System.out.println(isBalanced("({{[]}()})")); // false
        System.out.println(isBalanced("(({[]({[]})}){[(({[]}){[({[]})]})]((()){(({{[[]]}})){}}(){}{[({[]})]({[]})}({[]})"
                + "({[]}))}({[]})({[({[]})]}))(({[]})({[]}){[]})({[]({[]})})({[({[]})]})({[]})({[]})({[]})")); // true
    }
}
