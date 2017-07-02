/**
 * LeetCode 634 - Find the Derangement of an Array
 * <p>
 * Combinatorics
 */
public class _634 {
    public int findDerangement(int n) {
        final int mod = 1000000007;
        long[] f = new long[n + 10];
        f[1] = 0;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % mod * (i - 1) % mod;
        }
        return (int) f[n];
    }
}