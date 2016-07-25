/**
 * LeetCode 377 - Combination Sum IV
 *
 *
 * DP
 * f[i] means the number of different combinations that add up to i
 */
public class _377 {
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int num : nums)
                if (num <= i) f[i] += f[i - num];
        return f[target];
    }
}
