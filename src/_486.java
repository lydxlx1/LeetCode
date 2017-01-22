/**
 * LeetCode 486 - Predict the Winner
 * <p>
 * Game Theory + DP
 */
public class _486 {
    Integer[][] f, g;
    int[] nums;

    // Maximize the sum
    private int F(int i, int j) {
        if (i == j) return nums[i];
        if (f[i][j] != null) return f[i][j];

        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, G(i + 1, j) + nums[i]);
        ans = Math.max(ans, G(i, j - 1) + nums[j]);

        f[i][j] = ans;
        return ans;
    }

    // Minimize the sum
    private int G(int i, int j) {
        if (i == j) return 0;
        if (g[i][j] != null) return g[i][j];

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, F(i + 1, j));
        ans = Math.min(ans, F(i, j - 1));

        g[i][j] = ans;
        return ans;
    }

    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        f = new Integer[nums.length][nums.length];
        g = new Integer[nums.length][nums.length];
        int sum = 0;
        for (int num : nums) sum += num;

        return F(0, nums.length - 1) >= sum - F(0, nums.length - 1);
    }
}
