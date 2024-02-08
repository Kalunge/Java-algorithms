package stack;

import java.util.Stack;

public class StackAlgorithm {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        System.out.println("Start main");
        stack.push("main");

        System.out.println("Start builder");
        stack.push("builder");

        System.out.println("Start external-service");
        stack.push("external-service");

        System.out.println("End " + stack.pop());

        System.out.println("Start parse-external-data");
        stack.push(" parse-external-data");
        System.out.println("End " + stack.pop());
        System.out.println("End " + stack.pop());
        System.out.println("End " + stack.pop());

//        stack.peek()
    }
}
