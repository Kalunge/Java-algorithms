package stack;

import java.util.Stack;

public class StackAlgorithmChallenge {
    public static void printNextGreaterNumber(int[] array) {
//    we iterate over the array, trying to find the next greater element for the item on top of the stack
//    the stack contains the items we have already seen in the array
//    when we have reached the end of the array, each item that is still in the stack must have the next greater element of -1

        if (array.length == 0) {
            System.out.println();
        }
//        [16, 7, 2, 15

        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
//        [16, 16]

        for (int i = 0; i < array.length; i++) {
            int next = array[i];
            if (!stack.isEmpty()) {
                int popped = stack.pop();
                while (popped < next) {
                    System.out.println(popped + " -->" + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    popped = stack.pop();
                }
                if (popped > next) {
                    stack.push(popped);
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> " + -1);
        }


    }

    public static void main(String[] args) {
        int[] greaterArr = {16, 7, 2, 15};
        printNextGreaterNumber(greaterArr);
    }


}
