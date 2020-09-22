public class CorrectionRecursivite implements IRecursivite {
    public int serieArithmetique(int n) {
        if (n == 0) {
            return 0;
        }
        return serieArithmetique(n - 1) + n;
    }
}
