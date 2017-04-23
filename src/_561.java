import java.util.Arrays;

/**
 * LeetCode 561 - Array Partition I
 * <p>
 * Greedy algorithm
 */
public class _561 {
    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2)
            ans += nums[i];
        return ans;
    }
}
