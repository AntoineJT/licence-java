package recursivite;

public interface IRecursivite {
    /* 1 + 2 + 3 + ... + n */
    int serieArithmetique(int n);
    /* 1 * 2 * 3 * ... * n */
    int factorielle(int n);
    /* b^n avec b^(2n) = (b*b)^n */
    int puissance(int b, int n);

    int sommeChiffres(int n);
}
