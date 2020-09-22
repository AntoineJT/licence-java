package recursivite;

public class Recursivite implements IRecursivite {
    // Rien n'a été testé, tout est susceptible d'être n'importe quoi
    // cnt means counter
    private static int serieArithmetique_cnt(int acc, int index, int n) {
        if (index == n) {
            return acc;
        }
        return serieArithmetique_cnt(acc + index, index + 1, n);
    }

    @SuppressWarnings("unused")
    public int serieArithmetique_cnt(int n) {
        assert(n > 0);
        return serieArithmetique_cnt(0, 0, n);
    }

    private int serieArithmetique(int acc, int n) {
        if (n == 0) {
            return acc;
        }
        return serieArithmetique(acc + n, n - 1);
    }

    @SuppressWarnings("unused")
    @Override
    public int serieArithmetique(int n) {
        assert(n > 0);
        return serieArithmetique(0, n);
    }

    private int factorielle_old(int acc, int n) {
        if (n == 0) {
            return acc;
        }
        return factorielle_old(acc * n, n * 1);
    }

    @SuppressWarnings("unused")
    public int factorielle_old(int n) {
        assert(n > 0);
        return factorielle_old(0, n);
    }

    @SuppressWarnings("unused")
    @Override
    public int factorielle(int n) {
        if (n == 0) {
            return 0;
        }
        return factorielle(n - 1) * n;
    }

    private int puissance_old(int acc, int b, int n) {
        if (n == 0) {
            return acc;
        }
        return puissance_old(acc + b * b, n - 1);
    }

    public int puissance_old(int b, int n) {
        assert(n > 0);
        return puissance_old(0, b, n);
    }

    @Override
    public int puissance(int b, int n) {
        if (n == 0) {
            return b;
        }
        return puissance(b, n - 1) + b * b;
    }

    @Override
    public int sommeChiffres(int n) {
        // TODO
        return 0;
    }
}
