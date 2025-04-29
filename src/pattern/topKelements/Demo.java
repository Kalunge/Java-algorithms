package pattern.topKelements;

import java.util.*;

public class Demo {
    public static int minimumCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : ropes) {
            pq.add(num);
        }

        int result = 0;

        while (!pq.isEmpty()) {
            int num1 = pq.poll();
            int num2 = 0;
            if (!pq.isEmpty()) {
                num2 = pq.poll();
            }

            int currentResult = num1 + num2;
            result += currentResult;
        }
        return result;
    }

    public static String sortCharactersByFrequency(String str) {

        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            charFrequency.put(current, charFrequency.getOrDefault(current, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charFrequency.get(b) - charFrequency.get(a));

        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            pq.add(entry.getKey());
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!pq.isEmpty()) {
            Character pair = pq.poll();
             stringBuilder.append(String.valueOf(pair).repeat(Math.max(0, charFrequency.get(pair))));
//            for (int i = 0; i < charFrequency.get(pair); i++) {
//                stringBuilder.append(pair);
//            }
        }


        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        int[] ropes = new int[]{6, 4, 3, 2};
        System.out.println(minimumCost(ropes)); // 29
        System.out.println(sortCharactersByFrequency("buubble")); // bbbuule
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
