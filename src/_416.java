import java.util.stream.IntStream;

/**
 * LeetCode 416 - Partition Equal Subset Sum
 * <p>
 * 0/1-Knapsack
 */
public class _416 {
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0) return false;
        boolean[] f = new boolean[sum / 2 + 1];
        f[0] = true;
        for (int i : nums)
            for (int j = sum / 2; j - i >= 0; j--)
                f[j] = f[j] || f[j - i];
        return f[sum / 2];
    }
}