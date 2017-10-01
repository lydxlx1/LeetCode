import java.util.Arrays;

/**
 * LeetCode 689 - Maximum Sum of 3 Non-overlapping Subarrays
 * <p>
 * DP + Solution Finding
 */
class _689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        final int n = nums.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++)
            prefixSum[i] = nums[i] + (i - 1 >= 0 ? prefixSum[i - 1] : 0);

        long[][] dp = new long[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if (i - 1 >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                if (i >= k * (j + 1) - 1) {
                    long sum = prefixSum[i] - (i - k >= 0 ? prefixSum[i - k] : 0);
                    if (j == 0)
                        dp[i][j] = Math.max(dp[i][j], sum);
                    else
                        dp[i][j] = Math.max(dp[i][j], dp[i - k][j - 1] + sum);
                }
            }

        int[] res = new int[3];
        dfs(dp, n - 1, 2, res, k);
        return res;
    }

    private void dfs(long[][] dp, int i, int j, int[] res, int k) {
        if (j < 0) return;
        while (i - 1 >= 0 && dp[i - 1][j] == dp[i][j])
            i--;
        res[j] = i - k + 1;
        dfs(dp, i - k, j - 1, res, k);
    }

    public static void main(String[] args) {
        _689 sol = new _689();
        System.out.println(Arrays.toString(sol.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
        System.out.println(Arrays.toString(sol.maxSumOfThreeSubarrays(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 2)));
        System.out.println(Arrays.toString(sol.maxSumOfThreeSubarrays(new int[]{1, 1, 1, 1, 1, 1, 1, 2}, 2)));

    }
}
