package progdynamique;

public class TrianglePascal {
    private static long combinaisons(int p, int n, long[][] cache) { // retourne C(p, n)
        if (cache[p][n] != -1) {
            return cache[p][n];
        }
        if (p == 0 || p == n) {
            cache[p][n] = 1;
            return 1;
        }
        if (p < 0 || n < 0) {
            cache[p][n] = 0;
            return 0;
        }
        cache[p][n] = combinaisons(p - 1, n - 1, cache) + combinaisons(p, n - 1, cache);
        return cache[p][n];
    }
    
    public static long combinaisons(int p, int n) {
        long[][] cache = new long[p + 1][n + 1];
        for (int i = 0; i <= p; ++i) {
            for (int j = 0; j <= n; ++j) {
                cache[i][j] = -1;
            }
        }
        return combinaisons(p, n, cache);
    }
    
    static void trianglePascal(int nbLignes) {
        
        for (int n = 0; n <= nbLignes; ++n) {
            System.out.println();
            for (int p = 0; p <= n; ++p) {
                System.out.println(combinaisons(p, n));
            }
        }
    }
    
    public static void main(String... args) {
        trianglePascal(12);
    }
}
