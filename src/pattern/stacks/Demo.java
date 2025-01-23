package pattern.stacks;

import java.util.*;

public class Demo {

    public static String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }

    public static void evaluatePostFix(String str){

    }


    public static void main(String[] args) {
        String test = "code";

        String result = reverse(test);
        System.out.println(result);
    }
}
