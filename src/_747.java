/**
 * LeetCode 747 - Largest Number Greater Than Twice of Others
 */
public class _747 {

    public int dominantIndex(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > nums[idx])
                idx = i;
        for (int i = 0; i < nums.length; i++)
            if (i != idx && 2 * nums[i] > nums[idx]) return -1;
        return idx;
    }
}

