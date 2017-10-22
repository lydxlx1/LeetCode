/**
 * LeetCode 713 - Subarray Product Less Than K
 * <p>
 * O(n)-time sliding window approach
 * <p>
 * Since each number is >= 1, monotonicity is guaranteed. Therefore, we can use sliding window to solve this problem optimally.
 * <p>
 * BTW, if we take log to each number, the problem becomes the finding # of all subarrays with sum less than log(k).
 * And all the numbers in the array are positive.
 */
public class _713 {
    public static void main(String[] args) {
        _713 sol = new _713();
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 4));
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, prod = 1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (l < r && prod >= k)
                prod /= nums[l++];
            if (prod < k)
                ans += r - l + 1;
        }
        return ans;
    }
}
