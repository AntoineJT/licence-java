package recursivite;

@SuppressWarnings("unused")
public class CorrectionRecursivite implements IRecursivite {
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
        return 0;
    }

    @Override
    public int sommeChiffres(int n) {
        return 0;
    }
}
