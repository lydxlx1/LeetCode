/**
 * LeetCode 276 - Paint Fence
 * <p>
 * Combinatorial
 * <p>
 * Let f[i] denote the number choices to paint n fences where the leftmost one fence can only have k - 1 colors to choose.
 * Then, f[i] = (k - 1) * ( f[i - 1] + f[i - 2]).
 * And the final answer is f[i] / (k - 1) * k.
 */
public class _276 {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (k == 1) return n <= 2 ? 1 : 0;

        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] += (k - 1) * f[i - 1];
            if (i - 2 >= 0) f[i] += (k - 1) * f[i - 2];
        }
        return (int) ((long) f[n] / (k - 1) * k);
    }
}
