package designpatterns.strategy;

public class Test {
    public static void main(String... args) {
        int n = 10;
        long resultMult = square(new SquareComputationMultiplication(), n);
        long resultOdd = square(new SquareComputationOddNumbers(), n);
        System.out.println(resultMult);
        System.out.println(resultOdd);
    }

    private static long square(SquareComputationStrategy scs, int n) {
        return scs.compute(n);
    }
}
