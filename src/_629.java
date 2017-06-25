/**
 * LeetCode 629 - K Inverse Pairs Array
 * <p>
 * Counting
 * <p>
 * Let f[i][j] denote the # of permutation of 1..i such that there are EXACTLY j inversions.
 * <p>
 * Cleary, f[1][0] = 1, f[1][> 0] = 0
 * When i > 1, assume the last number of the permutation is x, where 1 <= x <= i.
 * <p>
 * [ ... ] x
 * This means:
 * 1) We immediately get i - x inversions for pairs like (x + 1, x), (x + 2, x), ..., (i, x).
 * 2) The remaining problem is indeed f[i - 1][j - (i - x)], if we remap 1, 2, ..., x - 1, x + 1, ..., i to
 * 1, 2, ..., i - 2, i - 1.
 * <p>
 * Thus, f[i][j] = f[i - 1][j] + f[i - 1][j - 2] + ... + f[i - 1][j - i + 1], which can be expressed by the
 * difference of two prefix sums.
 * Therefore, an O(nk)-time DP will do the job.
 */
public class _629 {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] f = new int[n + 1][k + 1];

        f[1][0] = 1; // don't forget this.
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) // make f[i - 1][] prefix-sums
                f[i - 1][j] = (f[i - 1][j] + f[i - 1][j - 1]) % mod;

            for (int j = 0; j <= k; j++)
                f[i][j] = (f[i - 1][j] - (j - i >= 0 ? f[i - 1][j - i] : 0) + mod) % mod;
        }
        return f[n][k];
    }
}