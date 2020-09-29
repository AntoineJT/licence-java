package heritage;

@SuppressWarnings("unused")
public class Cercle extends Point {
    private final int radius;

    @SuppressWarnings("unused")
    public Cercle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @SuppressWarnings("unused")
    public int getRadius() {
        return radius;
    }

    @SuppressWarnings("unused")
    public int getDiameter() {
        return radius * 2;
    }

    @Override
    public String toString() {
        return String.format("%s, radius = %d", super.toString(), radius);
    }
}
