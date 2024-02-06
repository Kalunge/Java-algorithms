package intro;

public class Algorithms {

    public static int findMaximum(int a, int b, int c) {

        if (a > b) {
            if (a > c || a == c) {
                return a;
            }
        }

        if (b > c) {
            return b;
        }

        return c;
    }

    public static int findMaximumTwo(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {
        int max = findMaximumTwo(1, 3, 4);
        int max2 = findMaximumTwo(12, 123, 43);
        System.out.println(max);
        System.out.println(max2);
    }
}
