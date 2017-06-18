/**
 * LeetCode 625 - Minimum Factorization
 * <p>
 * Greedy solution
 * <p>
 * 1. Larger factors will make shorter results.
 * 2. Larger factors will force the remaining part smaller.
 */
public class _625 {
    public int smallestFactorization(int a) {
        if (a == 1)
            return 1;
        long res = 0, pow10 = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                res += i * pow10;
                a /= i;
                pow10 *= 10;
            }
        }
        return a > 1 || res > Integer.MAX_VALUE ? 0 : (int) res;
    }
}
