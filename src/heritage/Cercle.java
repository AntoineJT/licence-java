package heritage;

@SuppressWarnings("unused")
public class Cercle extends Point {
    private final int rayon;

    @SuppressWarnings("unused")
    public Cercle(int x, int y, int rayon) {
        super(x, y);
        this.rayon = rayon;
    }

    @SuppressWarnings("unused")
    public int getRayon() {
        return rayon;
    }

    @SuppressWarnings("unused")
    public int getDiametre() {
        return rayon * 2;
    }

    @Override
    public String toString() {
        return String.format("%s, rayon = %d", super.toString(), rayon);
    }
}
