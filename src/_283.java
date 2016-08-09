/**
 * LeetCode 283 - Move Zeroes
 *
 * Similar ideas as Partition in Quicksort
 */
public class _283 {
    public void moveZeroes(int[] nums) {
        for (int l = 0, r = 0; r < nums.length; r++)
            if (nums[r] != 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
    }
}