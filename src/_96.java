/**
 * LeetCode 96 - Unique Binary Search Trees
 *
 * DP for computing Catalan Number
 */
public class _96 {
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                f[i] += f[j] * f[i - 1 - j];
        return f[n];
    }
}