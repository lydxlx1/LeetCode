/**
 * LeetCode 674 - Longest Continuous Increasing Subsequence
 * <p>
 * O(n)-time solution
 */
class _674 {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        for (int i = 0, j; i < nums.length; i = j) {
            for (j = i + 1; j < nums.length && nums[j - 1] < nums[j]; j++) ;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}