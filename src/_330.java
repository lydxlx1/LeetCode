/**
 * LeetCode 330 - Patching Array
 *
 * O(log n + num.length) - Greedy Algorithm
 *
 * Let [1, sum] be the continuous range that we can reach for the first i - 1 numbers.
 * Now, consider the i-th number.
 *
 * If num[i] <= sum + 1, we can enlarge the range to [1, sum + nums[i]] without making any empty gaps.
 *
 * Otherwise, we cannot directly take nums[i] and must add some smaller number to prevent forming holes.
 * What numbers are good for us? Well, we can add 1, 2, 3, ..., sum + 1, and if we patch a number x,
 * the range will be extended to [1, sum + x]. Then it is clear that we should greedy patch the number sum + 1.
 *
 * This gives us an O(log n + num.length)-time algorithm because of the following reasons.
 * 1) The total time of all the "if" part sums up to O(num.length), and
 * 2) sum always doubles when the "otherwise" part happens, which results in an O(log n) runtime.
 */
public class _330 {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int added = 0, i = 0;
        while (sum < n) {
            if (i < nums.length && nums[i] <= sum + 1) sum += nums[i++];
            else {
                added++;
                sum += sum + 1;
            }
        }
        return added;
    }
}
