/**
 * LeetCode 474 - Ones and Zeroes
 * <p>
 * (Regarding the title of this problem, I think the plural of zero is zeros...)
 * <p>
 * 0/1-Knapsack
 */
public class _474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length <= 0) return 0;

        int[] zeros = new int[strs.length];
        int[] ones = new int[strs.length];
        for (int i = 0; i < strs.length; i++)
            for (char ch : strs[i].toCharArray())
                if (ch == '0') zeros[i]++;
                else ones[i]++;

        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < zeros.length; i++)
            for (int j = m; j >= 0; j--)
                for (int k = n; k >= 0; k--)
                    if (j >= zeros[i] && k >= ones[i])
                        f[j][k] = Math.max(f[j][k], f[j - zeros[i]][k - ones[i]] + 1);
        return f[m][n];
    }
}