/**
 * LeetCode 486 - Predict the Winner
 * <p>
 * Shorter DP
 */
public class _486_1 {

    Integer[][] f;
    int[] nums;

    private int F(int i, int j, int s) {
        if (i == j) return s;
        if (f[i][j] != null) return f[i][j];
        f[i][j] = Math.max(s - F(i + 1, j, s - nums[i]), s - F(i, j - 1, s - nums[j]));
        return f[i][j];
    }

    public boolean PredictTheWinner(int[] nums) {
        f = new Integer[nums.length][nums.length];
        this.nums = nums;
        int sum = 0;
        for (int num : nums) sum += num;
        return F(0, nums.length - 1, sum) >= (sum + 1) / 2;
    }
}
