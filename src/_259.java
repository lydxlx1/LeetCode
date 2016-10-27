import java.util.Arrays;

/**
 * LeetCode 259 - 3Sum Smaller
 * <p>
 * Two-pointer method
 */
public class _259 {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1, k = nums.length - 1; j < k; )
                if (nums[i] + nums[j] + nums[k] < target) ans += k - (j++);
                else k--;
        return ans;
    }
}