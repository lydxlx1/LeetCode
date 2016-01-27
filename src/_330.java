/**
 * LeetCode 330 - Patching Array
 *
 * TBD later.
 */
public class _330 {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int added = 0, i = 0;
        while(sum < n) {
            if (i < nums.length && nums[i] <= sum + 1) sum += nums[i++];
            else {
                added++;
                sum += sum + 1;
            }
        }
        return added;
    }
}