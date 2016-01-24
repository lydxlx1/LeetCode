/**
 * LeetCode 303 - Range Sum Query - Immutable
 *
 * O(n) preprocessing
 * O(1) query
 *
 * Simple prefix sum trick
 */
public class _303 {

    private int[] sum;

    public _303(int[] nums) {
        sum = new int[nums.length];
        for (int i=0; i<sum.length; i++)
            sum[i] = nums[i] + (i == 0 ? 0 : sum[i - 1]);
    }

    public int sumRange(int i, int j) {
        return sum[j] - (i == 0 ? 0 : sum[i - 1]);
    }
}