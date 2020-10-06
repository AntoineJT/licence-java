package designpatterns.strategy;

public class SquareComputationMultiplication implements SquareComputationStrategy {
    @Override
    public long compute(int n) {
        return n * n;
    }
}
