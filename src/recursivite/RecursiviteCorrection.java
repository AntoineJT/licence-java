package recursivite;

@SuppressWarnings("unused")
public class RecursiviteCorrection implements IRecursivite {
    @Override
    public int serieArithmetique(int n) {
        if (n == 0) {
            return 0;
        }
        return serieArithmetique(n - 1) + n;
    }

    @Override
    public int factorielle(int n) {
        if (n == 0) {
            return 0;
        }
        return serieArithmetique(n - 1) * n;
    }

    @Override
    public int puissance(int b, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return puissance(b * b, n / 2);
        }
        return puissance(b, n - 1) * b;
    }

    @Override
    public int sommeChiffres(int n) {
        return 0;
    }
}
