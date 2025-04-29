package pattern.dynamicProgramming;

public class Demo {
    public static int fibTabulated(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        while (c <= n){
            c = a + b;

        }

        return 0;
    }

    public static int fibMemoized(int n) {
        return 0;
    }

    public static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibOptimize(int n){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(fibMemoized(4));
        System.out.println(fibTabulated(4));
        System.out.println(fibRecursive(4));

    }
}
