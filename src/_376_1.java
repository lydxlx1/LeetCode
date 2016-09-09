/**
 * LeetCode 376 - Wiggle Subsequence
 *
 * O(n) In-place Maximal/Minimal Finding
 */
public class _376_1 {
    public int wiggleMaxLength(int[] nums) {
        int len = 0, i = 0, j = 0, ans = 0;
        for (i = 0; i < nums.length; i = j + 1) {
            nums[len++] = nums[i];
            for (j = i; j + 1 < nums.length && nums[i] == nums[j + 1]; j++) ;
        }
        for (i = 0; i < len; i++) {
            int left = i - 1 < 0 ? 0 : Integer.compare(nums[i], nums[i - 1]);
            int right = i + 1 >= len ? 0 : Integer.compare(nums[i], nums[i + 1]);
            if (left * right >= 0) ans++;
        }
        return ans;
    }
}