package designpatterns.wrapper;

public class IntegerTrafique implements Anneau<IntegerTrafique> {
    private final int data;

    public IntegerTrafique(int data) {
        this.data = data;
    }

    @Override
    public IntegerTrafique un() {
        return new IntegerTrafique(1);
    }

    @Override
    public IntegerTrafique zero() {
        return new IntegerTrafique(0);
    }

    @Override
    public IntegerTrafique add(IntegerTrafique other) {
        return new IntegerTrafique(data + other.data);
    }

    @Override
    public IntegerTrafique mul(IntegerTrafique other) {
        return new IntegerTrafique(data * other.data);
    }
}
