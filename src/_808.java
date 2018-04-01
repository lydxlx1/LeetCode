/**
 * LeetCode 808 - Soup Servings
 * <p>
 * DP + Math
 */
public class _808 {
    Double[][] f, g;

    public double soupServings(int N) {
        if (N > 15000) return 1.0;

        N = (N + 24) / 25;
        f = new Double[N + 1][N + 1];
        g = new Double[N + 1][N + 1];
        return f(N, N) + g(N, N) / 2;
    }

    double f(int a, int b) {
        a = Math.max(a, 0);
        b = Math.max(b, 0);

        if (a == 0 && b > 0) return 1;
        if (a == 0 || b == 0) return 0;
        if (f[a][b] == null) {
            f[a][b] = (f(a - 4, b) + f(a - 3, b - 1) + f(a - 2, b - 2) + f(a - 1, b - 3)) / 4;
        }
        return f[a][b];
    }

    double g(int a, int b) {
        a = Math.max(a, 0);
        b = Math.max(b, 0);

        if (a == 0 && b == 0) return 1;
        if (a == 0 || b == 0) return 0;
        if (g[a][b] == null) {
            g[a][b] = (g(a - 4, b) + g(a - 3, b - 1) + g(a - 2, b - 2) + g(a - 1, b - 3)) / 4;
        }
        return g[a][b];
    }
}
