package progdynamique;

public class Fibonacci {
    private static long recCompute(int n, long[] cache) {
        if (cache[n] != - 1) {
            return cache[n];
        }
        if (n < 2) {
            cache[n] = n;
            return n;
        }
        cache[n] = recCompute(n - 2, cache) + recCompute(n - 1, cache);
        return cache[n];
    }

    public static long compute(int n) {
        long[] cache = new long[n + 1];
        for (int i = 0; i <= n; ++i) {
            cache[i] = -1;
        }
        return recCompute(n, cache);
    }

    public static void main(String[] args) {
       for (int i = 0; i < 200; ++i) {
           System.out.println(compute(i));
       }
    }
}
