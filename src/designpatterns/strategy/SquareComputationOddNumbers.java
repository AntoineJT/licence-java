package designpatterns.strategy;

public class SquareComputationOddNumbers implements SquareComputationStrategy {
    @Override
    public long compute(int n) {
        int result = 0;
        for (int i = 1; i <= n; ++i) {
            result += 2 * i - 1;
        }
        return result;
    }
}
