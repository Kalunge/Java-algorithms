package pattern.customDa;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(3);
        minStack.push(6);
        minStack.push(7);
        minStack.push(8);

        int min = minStack.getMin(); // 3
        int pop = minStack.pop(); // 8

        System.out.println("min is " + min + " pop is " + pop);


        TwoSum twoSum = new TwoSum();
        twoSum.addNumber(1);
        twoSum.addNumber(3);
        twoSum.addNumber(5);
        //twoSum.addNumber(5);
        System.out.println(twoSum.pairExists(4)); // true
        System.out.println(twoSum.pairExists(7)); // false
        System.out.println(twoSum.pairExists(8)); // true
        System.out.println(twoSum.pairExists(10)); // false with duplicate commented out
    }
}


class TwoSum {
    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void addNumber(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public boolean pairExists(int target) {
        for (int key : map.keySet()) {
            int complement = target - key;

            if (complement == key && map.get(complement) > 1
                    || complement != key && map.containsKey(complement)) {
                return true;
            }
        }

        return false;
    }
}


class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;

    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value) {
        main.push(value);

        if (min.isEmpty()) {
            min.push(value);
        } else {
            if (value < min.peek()) {
                min.push(value);
            } else {
                min.push(min.peek());
            }
        }
    }

    public int pop() {
        min.pop();
        return main.pop();

    }


    public int getMin() {
        return min.peek();
    }

}




















