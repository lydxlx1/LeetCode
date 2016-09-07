/**
 * LeetCode 136 - Single Number
 *
 * XOR Approach
 */
public class _136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) ans = ans ^ num;
        return ans;
    }
}